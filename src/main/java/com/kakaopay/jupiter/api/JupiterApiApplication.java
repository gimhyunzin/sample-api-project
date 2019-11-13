package com.kakaopay.jupiter.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class JupiterApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JupiterApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JupiterApiApplication.class);
    }
}
