package com.woniu.wuywboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {

    
    private Integer menuId;
    
    private String menuName;
    
    private String link;
    
    private Integer parent;

    private ArrayList<Menu> subMenu =new ArrayList<>();

}

