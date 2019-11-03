package com.sample.api.composite.orderlist.common.domain;

import lombok.Getter;

public enum Gender {
	MALE("남성"),
	FEMALE("여성"),
	OTHER("기타")
	;

	@Getter
	private String desc;

	Gender(String desc) {
		this.desc = desc;
	}
}
