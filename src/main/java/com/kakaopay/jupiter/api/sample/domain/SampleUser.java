package com.kakaopay.jupiter.api.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
@ApiModel(description = "샘플 정보")
public class SampleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "이름")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "나이")
    private Integer age;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(notes = "생일")
    private String birthDate;
}
