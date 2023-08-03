package com.woniu.wuywboot.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Integer paymentId;
    private Owner owner;
    private String month;
    private BigDecimal money;
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH-mm-ss")
    private LocalDateTime paymentTime;
}
