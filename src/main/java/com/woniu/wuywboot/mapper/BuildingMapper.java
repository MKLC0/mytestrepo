package com.woniu.wuywboot.mapper;

import com.woniu.wuywboot.entity.Building;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface BuildingMapper {
    void add(Building building);
    void update(Building building);
    void delete(int id);
    List<Building> select();
    Building queryById(int id);
    void updateStatus(@Param("ids")Integer[] ids);
    int getCount();
    List<Building> selectByPage(@Param("start") int start,@Param("pageSize")int pageSize);
}
