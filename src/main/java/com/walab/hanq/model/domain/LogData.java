package com.walab.hanq.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogData {
    private long id;
    private long event_id;
    private String code;
    private boolean is_deleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date reg_date;

    public LogData(long id, long event_id, String code) {
        this.id = id;
        this.event_id = event_id;
        this.code = code;
    }
}
