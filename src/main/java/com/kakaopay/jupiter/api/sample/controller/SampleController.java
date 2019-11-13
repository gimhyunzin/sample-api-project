package com.kakaopay.jupiter.api.sample.controller;

import com.kakaopay.jupiter.api.core.version.ApiVersion;
import com.kakaopay.jupiter.api.sample.domain.SampleParams;
import com.kakaopay.jupiter.api.sample.domain.SampleUser;
import com.kakaopay.jupiter.api.sample.domain.response.SampleUserListResponse;
import com.kakaopay.jupiter.api.sample.domain.response.SampleUserResponse;
import com.kakaopay.jupiter.api.sample.service.SampleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ApiResponses({
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")
})
@Slf4j
@RestController
@Api(tags = "샘플")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @ApiOperation(value = "샘플-v1", response = SampleUserListResponse.class, notes = "샘플정보-v1")
    @ApiVersion({ 1 })
    @GetMapping(value = "/sample")
    public SampleUserListResponse getUserListVer1(
            @ApiParam(value = "샘플 파라미터") SampleParams params
    ) {
        SampleUserListResponse res = new SampleUserListResponse();
        res.setData(sampleService.getUserListByName(params));

        return res;
    }

    @ApiOperation(value = "샘플-v2", response = SampleUserListResponse.class, notes = "샘플정보-v2")
    @ApiVersion({ 2 })
    @GetMapping(value = "/sample")
    public SampleUserListResponse getUserListVer2(
            @ApiParam(value = "샘플 파라미터") SampleParams params
    ) {
        SampleUserListResponse res = new SampleUserListResponse();
        res.setData(sampleService.getUserListByAge(params));

        return res;
    }

    @ApiOperation(value = "유저 등록", response = SampleUserResponse.class, notes = "유저 등록")
    @PostMapping(path = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public SampleUserResponse addUser(
            @ApiParam(value = "나이") int age,
            @ApiParam(value = "이름") String name
    ) {
        SampleUserResponse res = new SampleUserResponse();

        SampleUser user = new SampleUser();
        user.setAge(age);
        user.setName(name);

        SampleUser saved = sampleService.saveUser(user);

        res.setData(saved);
        res.setMessage("");
        res.setStatus(HttpStatus.OK);

        return res;
    }

    @ApiOperation(value = "유저 조회", response = SampleUserResponse.class, notes = "findOne")
    @GetMapping(path="/user/{id}")
    public SampleUserResponse getUserById(
            @ApiParam(value = "유저 id") @PathVariable("id") long id
    ) {
        SampleUserResponse res = new SampleUserResponse();
        res.setData(sampleService.getUserById(id));

        return res;
    }
}
