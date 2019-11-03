package com.sample.api.composite.orderlist.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@ApiModel(description = "묶음정보")
public class Bundle {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음번호")
    private Long bundleNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음단위 상태")
    private List<String> bundleStatus = Collections.emptyList();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음단위 상태 텍스트 컬러")
    private String bundleStatusTxtcolor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음단위 알림")
    private String bundleNoti;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음단위 추가정보")
    private String bundleExtra;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음단위 판매유형")
    private String bundleMallType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음단위 버튼 리스트")
    private List<Button> bundleButton = Collections.emptyList();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "주문정보 리스트")
    private List<OrderProd> orderProd = Collections.emptyList();
}
