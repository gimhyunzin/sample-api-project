package com.kakaopay.jupiter.api.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @Value("${spring.application.name}")
    private String metaInformation;

    private HttpHeaders getDefaultHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);
        httpHeaders.setContentType(mediaType);
        return httpHeaders;
    }

    @ExceptionHandler(Throwable.class)
    public Object handleServerError(HttpServletRequest req, Exception ex) {

        ResponseObject responseObject = setResponseObjectForException(req, ex, HttpStatus.INTERNAL_SERVER_ERROR, true);
        log.error("Throwable Error!!! uri: {}, trace: {}", req.getRequestURI(), ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(responseObject, getDefaultHttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceClientException.class)
    public HttpEntity<Object> handleResourceClientException(
            HttpServletRequest req, HttpServletResponse res, ResourceClientException ex
    ) {
        Throwable cause = ex.getCause();

        if (cause instanceof RestClientResponseException) {
            res.setStatus(ex.getHttpStatus().value());

            log.error("ResourceClientException Error!!! uri:{}, resourceUrl:{}, httpStatus:{}, getResponseBody:{}", req.getRequestURI(),
                    ex.getResourceUrl(), ex.getHttpStatus(), ((RestClientResponseException) cause).getResponseBodyAsString());
        }
        else {
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            ResponseObject responseObject = setResponseObjectForException(req, ex, HttpStatus.INTERNAL_SERVER_ERROR, false);

            log.error("ResourceClientException Error!!! uri:{}, resourceUrl:{}, httpStatus:{}, getResponseObject:{}, trace:{}", req.getRequestURI(),
                    ex.getResourceUrl(), ex.getHttpStatus(), responseObject, ExceptionUtils.getStackTrace(ex));

            return new HttpEntity<>(responseObject, getDefaultHttpHeaders());
        }

        return new HttpEntity<>(ex.getResponseBody(), getDefaultHttpHeaders());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object NoHandlerFoundException(HttpServletRequest req, Exception ex) {
        log.warn("404 Not Found Error!!! <uri:{}>, <RequestMethod:{}>, <HttpStatus:{}>", req.getRequestURI(), req.getMethod(), HttpStatus.NOT_FOUND.value());
        ResponseObject responseObject = setResponseObjectForException(req, ex, HttpStatus.NOT_FOUND, true);

        return new ResponseEntity<>(responseObject, getDefaultHttpHeaders(), HttpStatus.NOT_FOUND);
    }

    private ResponseObject setResponseObjectForException(HttpServletRequest request, Exception ex, HttpStatus httpStatus, boolean useMeta) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus(httpStatus.toString());

        ResponseErrorSource responseErrorSource = new ResponseErrorSource();
        responseErrorSource.setPointer(request.getRequestURI());

        responseError.setSource(responseErrorSource);
        responseError.setTitle(ExceptionUtils.getMessage(ex));
        responseError.setDetail(ExceptionUtils.getStackTrace(ex));

        if (useMeta) {
            responseError.setMeta(metaInformation);
        }

        ResponseObject responseObject = new ResponseObject();
        responseObject.addError(responseError);

        return responseObject;
    }
}
