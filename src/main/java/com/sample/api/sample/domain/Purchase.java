package com.sample.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@ApiModel(description = "구매정보")
public class Purchase {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "통합구분")
    private SampleType sampleType = SampleType.NONE;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "구매번호")
    private long purchaseNo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "구매일자")
    private String purchaseDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "버튼 리스트")
    private List<Button> purchaseButton = Collections.emptyList();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "묶음정보 리스트")
    private List<Bundle> bundle = Collections.emptyList();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "총 상품 갯수")
    private long totProdCnt;
}
