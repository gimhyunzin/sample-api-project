package com.sample.api.composite.orderlist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * servlet context 설정을 위한 config
 *
 * @author Jeonyeochul
 */
@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_PATH_PATTERNS       = {"swagger-ui.html", "/webjars/**"};
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS  = {"classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/"};

    /**
     * mvc:resources 설정을 처리합니다.
     *
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(CLASSPATH_PATH_PATTERNS).addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    /**
     * "/" path로 진입시 swagger-ui.html로 리다이렉트 처리합니다.
     *
     * @param registry ViewControllerRegistry
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("redirect:/swagger-ui.html");
    }
}
