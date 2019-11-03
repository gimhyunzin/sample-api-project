package com.sample.api.composite.orderlist.common.domain;

import lombok.Getter;

public enum MemberStatus {
	OK("정상"),
	BLIND("중지"),
	DEL("삭제")
	;

	@Getter
	private String desc;

	MemberStatus(String desc) {
		this.desc = desc;
	}
}
