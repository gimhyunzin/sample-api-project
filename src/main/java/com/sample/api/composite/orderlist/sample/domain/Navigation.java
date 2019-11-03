package com.sample.api.composite.orderlist.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "통합 주문리스트 네비")
public class Navigation {

    @JsonInclude
    @ApiModelProperty(notes = "조회 갯수")
    private int limit = 5;

    @JsonInclude
    @ApiModelProperty(notes = "배송2.0 기준 Key")
    private long shipNo;

    @JsonInclude
    @ApiModelProperty(notes = "레거시 기준 Key")
    private long liveNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "조회 종료일")
    private String schEndDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "조회 시작일")
    private String schStartDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "조회 상태")
    private String schType;
}
