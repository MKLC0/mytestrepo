package com.woniu.wuywboot.service;


import com.woniu.wuywboot.entity.Building;
import com.woniu.wuywboot.utils.PageBean;

import java.util.List;

public interface BuildingService {
     PageBean<Building> getPage(int page, int pageSize) ;
     void add(Building building);
     List<Building> selectAll();
}
