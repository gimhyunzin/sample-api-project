package com.sample.api.composite.orderlist.common.domain;

import lombok.Data;

@Data
public abstract class BaseResponse<T> {
	protected ResponseStatus state;
	protected String message;
	protected T data;
}
