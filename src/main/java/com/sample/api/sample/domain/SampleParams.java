package com.sample.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "샘플 파라미터")
public class SampleParams {

    @ApiModelProperty(notes = "조회 갯수")
    private int limit;

    @ApiModelProperty(notes = "조회 기준 Key")
    private long start;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "조회 상태")
    private String schType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "조회 시작일")
    private String schEndDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "조회 종료일")
    private String schStartDate;
}
