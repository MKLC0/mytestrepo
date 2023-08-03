package com.woniu.wuywboot.mapper;

import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.entity.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    void add(House house);
    void updateHouse(House house);
    void delete(@Param("ids") Integer[] ids);
    List<House> select(HouseQO houseQO);
    House queryById(Integer id);
}
