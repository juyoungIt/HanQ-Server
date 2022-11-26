package com.walab.hanq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.util.DateTime;
import com.walab.hanq.model.domain.LogData;
import com.walab.hanq.model.dto.AddLogRequestDTO;
import com.walab.hanq.repository.LogDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
public class LogDataService {
    @Autowired
    LogDataRepository logDataRepository;

    /* CREATE */
    public String addLogData(AddLogRequestDTO addLogRequestDTO) {
        HashSet<String> checked = new HashSet<>(); // 이미 확인된 QR 코드들을 로딩
        List<LogData> logDatas = logDataRepository.getLogData(addLogRequestDTO.getEvent_id());
        for(LogData l : logDatas) {
            System.out.println("code = " + l.getCode());
            checked.add(l.getCode());
        }

        if(!checked.contains(addLogRequestDTO.getCode())) {
            LogData logData = new LogData();
            logData.setEvent_id(addLogRequestDTO.getEvent_id());
            logData.setCode(addLogRequestDTO.getCode());
            try {
                logDataRepository.addLogData(logData);
            }
            catch (Exception e) {
                return "Invalid Request...";
            }
            return "Checked...";
        }
        return "Aleady Checked...";
    }

    /* READ */
    public String getAllLogData() throws JsonProcessingException {
        List<LogData> logDatas = logDataRepository.getAllLogData();
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(logDatas);
    }

    public String getLogData(long event_id) throws JsonProcessingException {
        List<LogData> logDatas = logDataRepository.getLogData(event_id);
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(logDatas);
    }

    /* UPDATE */

    /* DELETE */
    public void deleteLogData(long id) {
        logDataRepository.deleteLogData(id);
    }
}
