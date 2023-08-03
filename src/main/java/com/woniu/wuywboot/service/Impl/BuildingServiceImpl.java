package com.woniu.wuywboot.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.wuywboot.entity.Building;
import com.woniu.wuywboot.mapper.BuildingMapper;
import com.woniu.wuywboot.service.BuildingService;
import com.woniu.wuywboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Resource
    BuildingMapper buildingMapper;
//            = WuyeUtils.getMapper(BuildingMapper.class);

//    public PageBean<Building> getPage(int page, int pageSize) {
//        PageBean<Building> buildingPageBean = new PageBean<>();
//        List<Building> buildings = buildingMapper.selectByPage((page - 1) * pageSize, pageSize);
//        buildingPageBean.setData(buildings);
//        buildingPageBean.setActualNum(buildings.size());
//        buildingPageBean.setPageSize(pageSize);
//        buildingPageBean.setCurrPage(page);
//        int totalPage = buildingMapper.getCount() % pageSize == 0 ? buildingMapper.getCount() / pageSize : buildingMapper.getCount() / pageSize + 1;
//        buildingPageBean.setTotalPage(totalPage);
//        buildingPageBean.setTotalNums(buildingMapper.getCount());
//        return buildingPageBean;
//    }

    public PageBean<Building> getPage(int page, int pageSize) {
        Page<Object> page1 = PageHelper.startPage(page, pageSize);
        List<Building> buildings = buildingMapper.select();
        PageBean<Building> buildingPageBean = new PageBean<>();
        buildingPageBean.setData(buildings);
        buildingPageBean.setActualNum(buildings.size());
        buildingPageBean.setPageSize(pageSize);
        buildingPageBean.setCurrPage(page);
        buildingPageBean.setTotalPage(page1.getPages());
        buildingPageBean.setTotalNums((int) page1.getTotal());
        return buildingPageBean;
    }

    public void add(Building building){
        buildingMapper.add(building);
    }
    public List<Building> selectAll(){
        return  buildingMapper.select();
    }
}
