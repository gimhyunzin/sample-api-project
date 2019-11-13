package com.kakaopay.jupiter.api.core.exception;

import lombok.Getter;
import org.springframework.http.HttpHeaders;

@Getter
public class ResponseObject {
    private ResponseError error;

    public ResponseObject() {}

    public ResponseObject(String responseBody, HttpHeaders httpHeaders) {
    }

    public void addError(ResponseError error) {
        this.error = error;
    }
}
