package com.woniu.wuywboot.web;

import com.woniu.wuywboot.entity.Building;
import com.woniu.wuywboot.entity.House;
import com.woniu.wuywboot.service.BuildingService;
import com.woniu.wuywboot.utils.PageBean;
import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("building")
public class BuildingController {
    @Resource
    BuildingService buildingService;

    @RequestMapping("add")
    public ResponseResult<Boolean> add(@RequestBody Building building) {
        building.setBuildingStatus("y");
        buildingService.add(building);
//        System.out.println(buildingName+unity);
        ResponseResult<Boolean> booleanResponseResult = new ResponseResult<>();
        booleanResponseResult.setData(true);
        booleanResponseResult.setCode(200);
        booleanResponseResult.setMsg("success");
        return booleanResponseResult;
    }

    //    @RequestMapping("add")
//    public ResponseResult<Boolean> add(String buildingName,String unity) {
////        building.setBuildingStatus("y");
////        buildingService.add(building);
//        System.out.println(buildingName+unity);
//        ResponseResult<Boolean> booleanResponseResult = new ResponseResult<>();
//        booleanResponseResult.setData(true);
//        booleanResponseResult.setCode(200);
//        booleanResponseResult.setMsg("success");
//        return booleanResponseResult;
//    }
    @RequestMapping("list")
    public ResponseResult<PageBean<Building>> list(Integer page,Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        PageBean<Building> pages = buildingService.getPage(page,pageSize);
        ResponseResult<PageBean<Building>> pageBeanResponseResult = new ResponseResult<>();
        pageBeanResponseResult.setMsg("success");
        pageBeanResponseResult.setCode(200);
        pageBeanResponseResult.setData(pages);
        return pageBeanResponseResult;
    }
    @RequestMapping("all")
    public ResponseResult<List<Building>> all() {
        List<Building> buildings = buildingService.selectAll();
        ResponseResult<List<Building>> pageBeanResponseResult = new ResponseResult<>();
        pageBeanResponseResult.setMsg("success");
        pageBeanResponseResult.setCode(200);
        pageBeanResponseResult.setData(buildings);
        return pageBeanResponseResult;
    }

}
