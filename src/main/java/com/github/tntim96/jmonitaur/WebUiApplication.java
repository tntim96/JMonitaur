package com.github.tntim96.jmonitaur;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebUiApplication {
    private static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {
        applicationContext = SpringApplication.run(WebUiApplication.class, args);
    }

    public static void exit() {
        SpringApplication.exit(applicationContext, new ExitCodeGenerator[]{});
    }
}
