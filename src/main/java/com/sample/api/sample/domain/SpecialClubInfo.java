package com.sample.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "특가클럽 정보")
public class SpecialClubInfo {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "특가클렵 이용여부")
    private String clubYn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "특가클럽 이용등급")
    private String clubGrade;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "특가클럽 유효 시작일")
    private String clubStartDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "특가클럽 유효 종료일")
    private String clubEndDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "특가클럽 누적 적립포인트")
    private String clubSavePoint;
}
