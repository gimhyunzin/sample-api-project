package com.kakaopay.jupiter.api.sample.domain.response;

import com.kakaopay.jupiter.api.common.domain.BaseResponse;
import com.kakaopay.jupiter.api.sample.domain.SampleUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class SampleUserResponse extends BaseResponse<SampleUser> {
}
