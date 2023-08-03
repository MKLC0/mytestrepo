package com.woniu.wuywboot.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.entity.House;
import com.woniu.wuywboot.mapper.HouseMapper;
import com.woniu.wuywboot.service.HouseService;
import com.woniu.wuywboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseMapper houseMapper;

    @Override
    public void add(House house) {
        houseMapper.add(house);
    }

    @Override
    public PageBean<House> getAll(HouseQO houseQO, Integer page,Integer pageSize) {
        Page<Object> objects = PageHelper.startPage(page, pageSize);
        List<House> houses = houseMapper.select(houseQO);
        PageBean<House> housePageBean = new PageBean<>();
        housePageBean.setData(houses);
        housePageBean.setActualNum(houses.size());
        housePageBean.setPageSize(pageSize);
        housePageBean.setCurrPage(page);
        housePageBean.setTotalPage(objects.getPages());
        housePageBean.setTotalNums((int) objects.getTotal());
        return housePageBean;
    }

    @Override
    public void deleteByIds(Integer[] houseId) {
        houseMapper.delete(houseId);
    }

    @Override
    public House getById(Integer houseId) {
        return houseMapper.queryById(houseId);
    }

    @Override
    public void update(House house) {
        houseMapper.updateHouse(house);
    }
}
