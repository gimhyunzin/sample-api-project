package com.sample.api.sample.domain;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "샘플 구분")
public enum SampleType {
    SHIP,
    LIVE,
    NONE,
    ;
}
