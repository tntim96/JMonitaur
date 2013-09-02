package com.github.tntim96.jmonitaur.web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

public class Localhost {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        Server server = new Server(port);

        String wardir = "jmonitaur-parent/jmonitaur-webapp/src/main/webapp";

        WebAppContext context = new WebAppContext();
        context.setResourceBase(wardir);
        context.setDescriptor(wardir + "WEB-INF/web.xml");
        context.setConfigurations(new Configuration[] {
                new WebXmlConfiguration(),
                new WebInfConfiguration(),
                new MetaInfConfiguration(),
                new FragmentConfiguration()
        });

        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();
        server.join();
        /* TODO add
             - SSL
             - GZIP filter
             - NCSARequestLog
             - shutdown hook?
         */
    }


/*
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
*/
}
