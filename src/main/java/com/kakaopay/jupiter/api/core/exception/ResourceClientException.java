package com.kakaopay.jupiter.api.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceClientException extends Exception {
    private HttpStatus httpStatus;
    private String resourceUrl;
    private String ResponseBody;
}
