package com.sample.api.config;

import com.sample.api.core.interceptor.SleuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>제니퍼에서 추적 가능한 traceID, spanID 입력 기능을 추가하기 위한 config 입니다.</p><br>
 *
 * 제니퍼를 통한 모니터링 중에 이슈가 발생하면 해당 이슈에 대한 추적이 용이하지 않아<br> 제니퍼에서도 kibana 에서 수집하고 있는 traceID, spanID 를
 * 추가하도록 하기 위한 설정입니다.<br>
 *
 * @author Jeonyeochul
 * Jennifer 에서 추적 가능한 traceID, spanID 입력 기능 추가.</a>
 * @see SleuthInterceptor
 */
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
