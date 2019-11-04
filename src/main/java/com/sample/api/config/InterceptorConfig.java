package com.sample.api.config;

import com.sample.api.core.interceptor.SleuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Tracer tracer;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sleuthInterceptor())
                .addPathPatterns("/**/*");
    }

    public SleuthInterceptor sleuthInterceptor() {
        return new SleuthInterceptor(tracer);
    }
}
