package com.walab.hanq.repository;

import com.walab.hanq.model.domain.LogData;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LogDataRepository {
    @Autowired
    SqlSessionTemplate sqlSession;
    String namespace = "log_data";

    /* CRAETE */
    public void addLogData(LogData l) {
        Map<String, Object> param = new HashMap<>();
        param.put("event_id", l.getEvent_id());
        param.put("code", l.getCode());

        sqlSession.insert(namespace + ".addLogData", param);
    }

    /* READ */
    public List<LogData> getAllLogData() {
        return sqlSession.selectList(namespace + ".getAllLogData");
    }
    public LogData getLogData(long id) {
        return sqlSession.selectOne(namespace + ".getLogData", id);
    }

    /* UPDATE */

    /* DELETE */
    public void deleteLogData(long id) {
        sqlSession.delete(namespace + ".deleteLogData", id);
    }
}
