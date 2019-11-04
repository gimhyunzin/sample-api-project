package com.sample.api.common.domain;

import lombok.Getter;

public enum DataStatus {
	OK("정상"),
	DEL("삭제")
	;

	@Getter
	private String desc;

	DataStatus(String desc) {
		this.desc = desc;
	}
}
