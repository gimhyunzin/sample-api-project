package com.sample.api.composite.orderlist.sample.controller;

import com.sample.api.composite.orderlist.sample.domain.Navigation;
import com.sample.api.composite.orderlist.sample.domain.Sample;
import com.sample.api.composite.orderlist.sample.domain.response.SampleResponse;
import com.sample.api.composite.orderlist.sample.repository.SampleRepository;
import com.sample.api.composite.orderlist.sample.service.SampleService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "SampleController", description = "샘플")
@ApiResponses(value = {
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")
})
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @Autowired
    private SampleRepository sampleRepository;

    /**
     * 마이페이지 > 통합 주문리스트
     */
    @ApiOperation(value = "마이페이지 통합 주문리스트", response = SampleResponse.class, notes = "통합 주문리스트 (배송2.0 + 레거시)")
    @PostMapping(value = "/mypage/purchase")
    public ResponseEntity<SampleResponse> mypagePurchase(
            @RequestBody @ApiParam(value = "네비게이션") Navigation navigation
    ) {

        return null;
//        SampleResponse response = new SampleResponse();
//        response.setNavigation(navigation);
//        return ResponseEntity.ok(response);
//
//        return ResourceConverter.toResponseObject(
//                purchaseCompositeService.getCompositePurchase(headers, navigation)
//        );
    }

    @RequestMapping(path = "/hello")
    public @ResponseBody String sayHello() {
        log.info("GET called on /hello resource");
        return "Hello from Spring Boot Backend!";
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody long addNewUser (@RequestParam String firstName, @RequestParam String lastName) {
        Sample sample = new Sample(firstName, lastName);
        sampleRepository.save(sample);

        log.info(sample.toString() + " successfully saved into DB");

        return sample.getId();
    }

    @GetMapping(path="/user/{id}")
    public @ResponseBody Sample getUserById(@PathVariable("id") long id) {
        return sampleRepository.findOne(id);
    }
}
