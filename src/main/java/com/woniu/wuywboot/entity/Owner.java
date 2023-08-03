package com.woniu.wuywboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner implements Serializable {

    
    private Integer ownerId;
    
    private String ownerName;
    
    private String gender;
    
    private String telnumber;
    
    private String idCard;
    
    private String ownerStatus;

}

