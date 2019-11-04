package com.sample.api.core.interceptor;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SleuthInterceptor extends HandlerInterceptorAdapter {

    private Tracer tracer;

    public SleuthInterceptor(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = Span.idToHex(tracer.getCurrentSpan().getTraceId());
        String spanId = Span.idToHex(tracer.getCurrentSpan().getSpanId());
        sleuthTraceGuidVoidCall(traceId);
        sleuthSpanGuidVoidCall(spanId);
        return super.preHandle(request, response, handler);
    }

    private void sleuthTraceGuidVoidCall(String traceId) {
    }

    private void sleuthSpanGuidVoidCall(String spanId) {
    }
}
