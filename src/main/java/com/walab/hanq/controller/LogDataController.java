package com.walab.hanq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.walab.hanq.service.LogDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/log")
public class LogDataController {
    @Autowired
    LogDataService logDataService;

    /* CREATE */
    @ApiOperation(value = "QR 인식로그 추가", notes = "QR코드를 인식하여 얻은 코드를 바탕으로 로그 정보를 추가합니다.")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "event_id"
                            , value = "출석한 학부행사 종류"
                            , required = true
                            , dataType = "long"
                            , paramType = "query"
                    ),
                    @ApiImplicitParam(
                            name = "code"
                            , value = " QR 코드값"
                            , required = true
                            , dataType = "string"
                            , paramType = "query"
                    )
            }
    )
    @PostMapping(value="")
    public void addLogData(HttpServletRequest httpServletRequest) {
        long event_id = Long.parseLong(httpServletRequest.getParameter("event_id"));
        String code = httpServletRequest.getParameter("code");

        logDataService.addLogData(event_id, code);
    }

    /* READ */
    @ApiOperation(value = "QR 인식로그 조회 (전체)", notes = "현재까지 수집된 모든 로그를 로딩합니다.")
    @GetMapping(value="/all", produces = "application/json; charset=utf8")
    public String getAllLogData() throws JsonProcessingException {
        return logDataService.getAllLogData();
    }

    @ApiOperation(value = "QR 인식로그 조회 (단건)", notes = "특정 ID를 가진 Log 정보를 조회합니다.")
    @ApiImplicitParam(
            name = "id"
            , value = "Log의 id"
            , required = true
            , dataType = "long"
            , paramType = "path"
    )
    @GetMapping(value="/{id}", produces = "application/json; charset=utf8")
    public String getLogData(@PathVariable long id) throws JsonProcessingException {
        return logDataService.getLogData(id);
    }

    /* UPDATE */

    /* DELETE */
    @ApiOperation(value = "QR 인식로그 삭제", notes = "특정 ID를 가진 Log 정보를 삭제합니다.")
    @ApiImplicitParam(
            name = "id"
            , value = "Log의 id"
            , required = true
            , dataType = "long"
            , paramType = "path"
    )
    @PutMapping(value = "/{id}")
    public void deleteLogData(@PathVariable long id) {
        logDataService.deleteLogData(id);
    }
}
