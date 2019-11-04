package com.sample.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "유저 정보")
public class UserInfo {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "총 배송중 건수")
    private long shippingCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "총 할인쿠폰 건수")
    private long myCouponCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "총 포인트 잔액")
    private long myPoint;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "총 티켓 건수")
    private long ticketCount;
}
