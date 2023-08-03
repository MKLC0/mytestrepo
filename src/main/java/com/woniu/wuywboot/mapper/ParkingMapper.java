package com.woniu.wuywboot.mapper;

import com.woniu.wuywboot.QO.ParkingQO;
import com.woniu.wuywboot.entity.Parking;

import java.util.List;

public interface ParkingMapper {
    void add(Parking parking);
    void delete(Integer parkingId);
    List<Parking> queryAll(ParkingQO parkingQO);
}
