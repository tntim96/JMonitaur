package com.github.tntim96.jmonitaur.web;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.NCSARequestLog;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.handler.RequestLogHandler;
import org.mortbay.jetty.security.SslSocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.servlet.GzipFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Localhost {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext[] webAppContexts = {
                new WebAppContext("jmonitaur-parent/jmonitaur-webapp/src/main/webapp", "")
        };

        NCSARequestLog log = new NCSARequestLog();
        RequestLogHandler logHandler = new RequestLogHandler();
        logHandler.setRequestLog(log);

        server.addHandler(new StopJettyHandler());
        for (WebAppContext webAppContext : webAppContexts) {
            webAppContext.addFilter(GzipFilter.class, "*", Handler.DEFAULT);
            server.addHandler(webAppContext);
        }

        server.addConnector(setupHttpsConnector());
        server.start();
    }

    private static SslSocketConnector setupHttpsConnector() {
        //System.setProperty("com.github.tntim96.jmonitaur.ssl.trust.all", "true");

        SslSocketConnector connector = new SslSocketConnector();
        connector.setTruststore("keystore");
        connector.setTrustPassword("password");
        connector.setKeystore("keystore");
        connector.setKeyPassword("password");
        connector.setPassword("password");
        connector.setPort(8443);

        return connector;
    }

    private static class StopJettyHandler extends AbstractHandler {

        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
                throws IOException, ServletException {

            if (target.equals("/stop")) {
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
                PrintWriter writer = response.getWriter();
                writer.print("Shutting down server");
                writer.flush();
                stopJetty(request);
            }
        }

        private void stopJetty(HttpServletRequest request) {
            ((Request) request).setHandled(true);
            Thread death = new Thread(new ShutdownThread(getServer()));
            death.start();
        }
    }

    private static class ShutdownThread implements Runnable {
        private final Server server;

        public ShutdownThread(Server server) {
            this.server = server;
        }

        public void run() {
            try {
                server.stop();
            } catch (Exception e) {
                // ignore
            }
        }
    }
}
