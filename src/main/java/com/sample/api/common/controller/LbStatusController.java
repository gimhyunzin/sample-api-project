package com.sample.api.common.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@RestController
public class LbStatusController {

    @ApiOperation(value = "LbStatusCheck Controller")
    @GetMapping("/lbStatusCheck")
    public ResponseEntity<String> getLbStatusCheck() {
        String lbStatusFilePath = System.getProperty("file.path.lbstatus");

        if (StringUtils.isBlank(lbStatusFilePath)) {
            log.error("file.path.lbstatus property is not found.");
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        Stream<String> lines = null;
        String result;
        try {
            lines = Files.lines(Paths.get(lbStatusFilePath));
            Optional<String> stringOptional = lines.findFirst();
            result = stringOptional.orElse(null);
        } catch (Exception e) {
            log.error("lb status file error: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } finally {
            if (lines != null) {
                lines.close();
            }
        }

        if (StringUtils.isEmpty(result)) {
            log.error("lb status file's contents is EMPTY!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result.trim(), HttpStatus.OK);
    }
}
