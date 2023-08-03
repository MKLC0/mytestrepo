package com.woniu.wuywboot.QO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentQO {
    private Integer ownerId;
    private String month;
    private LocalDateTime start;
    private LocalDateTime end;
}
