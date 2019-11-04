package com.sample.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_PATH_PATTERNS       = {"swagger-ui.html", "/webjars/**"};
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS  = {"classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/"};

    /**
     * mvc:resources 설정
     *
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(CLASSPATH_PATH_PATTERNS).addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    /**
     * "/" 진입 시, swagger-ui.html 리다이렉트
     *
     * @param registry ViewControllerRegistry
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }
}
