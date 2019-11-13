package com.kakaopay.jupiter.api.core.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseError {
    private String status;
    private String title;
    private String detail;
    private String meta;
    private ResponseErrorSource source;
}
