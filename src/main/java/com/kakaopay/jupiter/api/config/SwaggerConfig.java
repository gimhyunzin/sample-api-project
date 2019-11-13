package com.kakaopay.jupiter.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
@ComponentScan({"com.kakaopay.jupiter.api"})
public class SwaggerConfig extends WebSecurityConfigurerAdapter {

    private static String[] SWAGGER_URL_PATHS = new String[] {
            "/swagger-ui.html**",
            "/swagger-resources/**",
            "/v2/api-docs**",
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.requestMatchers()
                .antMatchers(SWAGGER_URL_PATHS)
                .and()
                .authorizeRequests()
                .antMatchers(SWAGGER_URL_PATHS)
                .permitAll();
    }

    // TODO
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .select()
                .apis(basePackage("com.kakaopay.jupiter.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Jupiter API")
                .description("REST API")
                .version("1.0")
                .build();
    }
}
