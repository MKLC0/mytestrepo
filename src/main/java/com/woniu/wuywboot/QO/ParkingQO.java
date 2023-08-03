package com.woniu.wuywboot.QO;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ParkingQO {
    private String parkingAddress;
    private BigDecimal minArea;
    private BigDecimal maxArea;
    private Integer page;
    private Integer pageSize;
}
