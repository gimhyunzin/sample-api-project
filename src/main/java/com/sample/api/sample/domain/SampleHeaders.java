package com.sample.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sample.api.common.domain.SampleHeaderKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor(staticName = "of")
@Data
@ApiModel(description = "샘플 헤더 정보")
public class SampleHeaders {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "로그인 정보 - 회원")
    private String loginUser = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "로그인 정보 - 비회원")
    private String nonUser = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "mid - 회원")
    private String loginMid = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "mid - 비회원")
    private String nonMid = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "접속 앱 명칭")
    private String appName = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "User-Agent")
    private String userAgent = "PC";

    /**
     * 구매정보 요청헤더
     */
    public static HttpHeaders convert(SampleHeaders headers) {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.set(SampleHeaderKey.LOGIN_USER_INFO, headers.getLoginUser());
        httpHeaders.set(SampleHeaderKey.MID, headers.getLoginMid());
        httpHeaders.set(SampleHeaderKey.NON_USER_INFO, headers.getNonUser());
        httpHeaders.set(SampleHeaderKey.NON_USER_MID, headers.getNonMid());
        httpHeaders.set(SampleHeaderKey.USER_AGENT_TYPE, headers.getUserAgent());
        httpHeaders.setContentType(new MediaType(MediaType.APPLICATION_JSON_UTF8, StandardCharsets.UTF_8));

        return httpHeaders;
    }


    public static void validation(SampleHeaders headers) throws IllegalArgumentException {

        if (StringUtils.isEmpty(headers.getLoginUser()) && StringUtils.isEmpty(headers.getNonUser())) {
            throw new IllegalArgumentException("회원 정보가 존재하지 않습니다.");
        }

        if (StringUtils.isNotEmpty(headers.getLoginUser()) && StringUtils.isNotEmpty(headers.getNonUser())) {
            throw new IllegalArgumentException("회원 정보가 올바르지 않습니다.");
        }
    }
}
