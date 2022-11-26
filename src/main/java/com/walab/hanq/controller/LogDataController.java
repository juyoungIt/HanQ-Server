package com.walab.hanq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.walab.hanq.model.dto.AddLogRequestDTO;
import com.walab.hanq.service.LogDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/log")
public class LogDataController {
    @Autowired
    LogDataService logDataService;

    /* CREATE */
    @ApiOperation(value = "QR 인식로그 추가")
    @PostMapping(value="")
    public String addLogData(@RequestBody AddLogRequestDTO addLogRequestDTO) {
        return logDataService.addLogData(addLogRequestDTO);
    }

    /* READ */
    @ApiOperation(value = "QR 인식로그 조회 (전체)", notes = "현재까지 수집된 모든 로그를 로딩합니다.")
    @GetMapping(value="/all", produces = "application/json; charset=utf8")
    public String getAllLogData() throws JsonProcessingException {
        return logDataService.getAllLogData();
    }

    @ApiOperation(value = "QR 인식로그 조회 (다건, 행사기준)", notes = "특정 행사에 대한 Log 정보를 조회합니다.")
    @GetMapping(value="/{event_id}", produces = "application/json; charset=utf8")
    public String getLogData(@PathVariable long event_id) throws JsonProcessingException {
        return logDataService.getLogData(event_id);
    }

    /* UPDATE */

    /* DELETE */
    @ApiOperation(value = "QR 인식로그 삭제", notes = "특정 ID를 가진 Log 정보를 삭제합니다.")
    @PutMapping(value = "/{id}")
    public void deleteLogData(@PathVariable long id) {
        logDataService.deleteLogData(id);
    }
}
