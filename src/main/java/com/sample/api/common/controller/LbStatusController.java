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

    /**
     * 시스템팀에서 배포할 때 L4에서 이 url을 호출하여 특정 위치에 있는 파일을 읽어들여 그 값을 리턴받아 L4에서 넣었다 뺐다 할 수 있도록 제공하는 메소드입니다
     *
     * 결과 체크는 http status 를 확인하지 않고 response body 만을 체크하고 있음.
     *
     * @return 시스템팀에서 편집한 파일의 내용
     */
    @ApiOperation(value = "lbStatusCheck Controller", notes = "시스템팀에서 배포할 때 L4에서 이 url을 호출하여 특정 위치에 있는 파일을 읽어들여, " +
            "그 값을 리턴받아 L4에서 넣었다 뺐다 할 수 있도록 제공하는 메소드입니다")
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
