package com.woniu.wuywboot.QO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseQO {
    Integer buildingId;
    Integer houseNo;
    BigDecimal minArea;
    BigDecimal maxArea;
    private Integer page;
    private Integer pageSize;
}
