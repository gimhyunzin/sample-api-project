package com.kakaopay.jupiter.api.common.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public abstract class BaseResponse<T> {
    protected HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    protected String message = "";
    protected T data;
}
