package com.sample.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "버튼정보")
public class Button {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼명")
    private String text;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼 ID")
    private String action;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼 Key")
    private Long value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼 구분값")
    private String deliveryType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼 구분값")
    private String claimType;
}
