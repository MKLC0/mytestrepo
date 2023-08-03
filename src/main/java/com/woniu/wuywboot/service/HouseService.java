package com.woniu.wuywboot.service;


import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.entity.House;
import com.woniu.wuywboot.utils.PageBean;

public interface HouseService {
    void add(House house);
    PageBean<House> getAll(HouseQO houseQO, Integer page,Integer pageSize);

    void deleteByIds(Integer[] houseId);

    House getById(Integer houseId);

    void update(House house);
}
