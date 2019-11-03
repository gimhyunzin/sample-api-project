package com.sample.api.composite.orderlist.config;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web config
 */
@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean xssEscapeServletFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
