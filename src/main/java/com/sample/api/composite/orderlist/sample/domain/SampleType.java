package com.sample.api.composite.orderlist.sample.domain;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "샘플 구분")
public enum SampleType {
    SHIP,
    LIVE,
    NONE,
    ;
}
