package com.kakaopay.jupiter.api.common.controller;

import com.kakaopay.jupiter.api.common.domain.JupiterResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ApiResponses({
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")
})
@Slf4j
@RestController
@Api(tags = "Hello Jupiter")
public class JupiterController {

    @ApiOperation(value = "Health Check", response = String.class, notes = "ping-pong")
    @GetMapping(value = "/api/ping")
    @ResponseStatus(HttpStatus.OK)
    public JupiterResponse healthCheck() {
        JupiterResponse res = new JupiterResponse();

        res.setData("Jupiter is healthy !");
        res.setMessage("pong");
        res.setStatus(HttpStatus.OK);

        return res;
    }
}
