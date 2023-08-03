package com.woniu.wuywboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    
    private Integer userId;
    
    private String account;
    
    private String password;
    
    private String role;
    
    private String userStatus;

    private List<Menu> menus;
}

