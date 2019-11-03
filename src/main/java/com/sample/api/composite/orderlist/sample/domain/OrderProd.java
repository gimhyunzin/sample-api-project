package com.sample.api.composite.orderlist.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@ApiModel(description = "주문정보")
public class OrderProd {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "주문번호")
    private Long orderNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼 리스트")
    private List<Button> orderButton = Collections.emptyList();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "상품번호")
    private Long prodNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "상품명")
    private String prodNm;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "상품수량")
    private Long prodQty;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "상품가격")
    protected Long prodPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "썸네일 이미지 경로")
    private String imgUrl;
}
