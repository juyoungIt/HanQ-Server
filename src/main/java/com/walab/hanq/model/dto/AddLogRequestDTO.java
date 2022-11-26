package com.walab.hanq.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddLogRequestDTO {
    private long event_id; // 인식한 행사의 id
    private String code;   // 인식한 QR code 값
}
