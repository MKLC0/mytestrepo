package com.woniu.wuywboot.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.woniu.wuywboot.QO.ParkingQO;
import com.woniu.wuywboot.entity.Parking;
import com.woniu.wuywboot.mapper.ParkingMapper;
import com.woniu.wuywboot.service.ParkingService;
import com.woniu.wuywboot.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Resource
    ParkingMapper parkingMapper;
    @Override
    public void add(Parking parking) {
        parkingMapper.add(parking);
    }

    @Override
    public PageBean<Parking> getAll(ParkingQO parkingQO, Integer page, Integer pageSize) {
        Page<Object> objects = PageHelper.startPage(page, pageSize);
        List<Parking> parkings = parkingMapper.queryAll(parkingQO);
        PageBean<Parking> parkingPageBean = new PageBean<>();
        parkingPageBean.setData(parkings);
        parkingPageBean.setActualNum(parkings.size());
        parkingPageBean.setPageSize(pageSize);
        parkingPageBean.setCurrPage(page);
        parkingPageBean.setTotalPage(objects.getPages());
        parkingPageBean.setTotalNums((int) objects.getTotal());
        return parkingPageBean;
    }

    @Override
    public void deleteById(Integer parkingId) {
        parkingMapper.delete(parkingId);
    }
}
