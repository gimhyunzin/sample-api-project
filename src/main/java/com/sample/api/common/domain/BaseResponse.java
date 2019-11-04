package com.sample.api.common.domain;

import lombok.Data;

@Data
public abstract class BaseResponse<T> {
	protected ResponseStatus state;
	protected String message;
	protected T data;
}
