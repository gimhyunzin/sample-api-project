package com.kakaopay.jupiter.api.config;

import com.kakaopay.jupiter.api.core.version.ApiVersionMappingHandler;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class ApiVersionConfig {

        @Bean
        public WebMvcRegistrations webMvcRegistrations() {
            return new WebMvcRegistrations() {
                @Override
                public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                    return new ApiVersionMappingHandler("v");
                }
            };
        }
}
