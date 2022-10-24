package com.walab.hanq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;
import com.walab.hanq.model.domain.LogData;
import com.walab.hanq.repository.LogDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogDataService {
    @Autowired
    LogDataRepository logDataRepository;

    /* CREATE */
    public void addLogData(long event_id, String code) {
        LogData logData = new LogData();
        logData.setEvent_id(event_id);
        logData.setCode(code);
        logDataRepository.addLogData(logData);
    }

    /* READ */
    public String getAllLogData() throws JsonProcessingException {
        List<LogData> logDatas = logDataRepository.getAllLogData();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(logDatas);
    }

    public String getLogData(long id) throws JsonProcessingException {
        LogData logData = logDataRepository.getLogData(id);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(logData);
    }

    /* UPDATE */

    /* DELETE */
    public void deleteLogData(long id) {
        logDataRepository.deleteLogData(id);
    }
}
