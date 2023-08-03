package com.woniu.wuywboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House implements Serializable {

    private Integer houseId;
    
    private String houseNo;
    
    private Building building;
    
    private BigDecimal area;
    
    private String remark;
    
    private Owner owner;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate submitTime;
    
    private String photo;


}

