package com.sample.api.sample.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.api.common.domain.BaseResponse;
import com.sample.api.sample.domain.Navigation;
import com.sample.api.sample.domain.Purchase;
import com.sample.api.sample.domain.SpecialClubInfo;
import com.sample.api.sample.domain.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(description = "구매정보 response")
public class SampleResponse extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "통합 주문리스트 네비")
    private Navigation navigation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "구매정보 리스트")
    private List<Purchase> purchase;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "유저정보")
    private UserInfo userInfo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "특가클럽 정보")
    private SpecialClubInfo specialClubInfo;
}
