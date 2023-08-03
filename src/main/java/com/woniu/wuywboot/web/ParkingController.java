package com.woniu.wuywboot.web;

import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.QO.ParkingQO;
import com.woniu.wuywboot.entity.House;
import com.woniu.wuywboot.entity.Parking;
import com.woniu.wuywboot.service.ParkingService;
import com.woniu.wuywboot.utils.PageBean;
import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Resource
    ParkingService parkingService;
    @RequestMapping("add")
    public ResponseResult<?> add(@RequestBody Parking parking){
        System.out.println(parking);
        parkingService.add(parking);
        ResponseResult<String> stringResponseResult = new ResponseResult<>();
        stringResponseResult.setData("ok");
        stringResponseResult.setCode(200);
        stringResponseResult.setMsg("ok");
        return stringResponseResult;
    }
    @RequestMapping("delete")
    public ResponseResult<?> delete(@RequestBody Parking parking){
        parkingService.deleteById(parking.getParkingId());
        ResponseResult<String> stringResponseResult = new ResponseResult<>();
        stringResponseResult.setData("ok");
        stringResponseResult.setCode(200);
        stringResponseResult.setMsg("ok");
        return stringResponseResult;
    }
    @RequestMapping("list")
    public ResponseResult<PageBean<Parking>> list(@RequestBody ParkingQO parkingQO) {
        PageBean<Parking> parkingPageBean = parkingService.getAll(parkingQO, parkingQO.getPage(), parkingQO.getPageSize());
        ResponseResult<PageBean<Parking>> pageBeanResponseResult = new ResponseResult<>();
        pageBeanResponseResult.setData(parkingPageBean);
        pageBeanResponseResult.setCode(200);
        pageBeanResponseResult.setMsg("ok");
        return pageBeanResponseResult;
    }
}
