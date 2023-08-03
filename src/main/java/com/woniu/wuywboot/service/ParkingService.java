package com.woniu.wuywboot.service;

import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.QO.ParkingQO;
import com.woniu.wuywboot.entity.House;
import com.woniu.wuywboot.entity.Parking;
import com.woniu.wuywboot.utils.PageBean;

public interface ParkingService {
    void add(Parking parking);
    PageBean<Parking> getAll(ParkingQO parkingQO, Integer page, Integer pageSize);
    void deleteById(Integer parkingId);
}
