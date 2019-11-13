package com.kakaopay.jupiter.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ApiModel(description = "샘플 파라미터")
public class SampleParams {

    @ApiModelProperty(notes = "갯수")
    private int limit = 0;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "이름")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "나이")
    private int age = 0;
}
