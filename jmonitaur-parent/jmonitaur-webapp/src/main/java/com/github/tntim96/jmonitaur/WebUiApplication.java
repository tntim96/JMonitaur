package com.github.tntim96.jmonitaur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebUiApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebUiApplication.class, args);
    }

}
