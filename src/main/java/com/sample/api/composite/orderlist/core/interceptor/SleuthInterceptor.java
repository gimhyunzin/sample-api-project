package com.sample.api.composite.orderlist.core.interceptor;

import com.sample.api.composite.orderlist.config.InterceptorConfig;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 제니퍼에서 모든 호출에서 traceID, spanID 를 guid 로 모니터링 할 수 있도록<br>
 * 빈 메시드를 호출해주는 인터셉터로 자체로서 가지는 기능은 없습니다.<br><br>
 *
 * 리퀘스트 당 생성되는 traceID, spanID 값을 빈 메서드에 인자로 입력합니다.<br>
 * 입력 된 인자는 제니퍼의 설정을 통해서 guid라는 필드로 모니터링 가능합니다.<br>
 *
 * @author Jeonyeochul
 * @see InterceptorConfig
 */
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
