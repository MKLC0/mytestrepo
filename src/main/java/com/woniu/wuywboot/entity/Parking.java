package com.woniu.wuywboot.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
public class Parking {
    @NotBlank
    private Integer parkingId;
    @NotBlank
    private String parkingAddress;
    @NotBlank
    private BigDecimal parkingArea;
    private String parkingStatus;
}
