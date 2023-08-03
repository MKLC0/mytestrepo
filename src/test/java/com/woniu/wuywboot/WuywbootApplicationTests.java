package com.woniu.wuywboot;

import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.mapper.HouseMapper;
import com.woniu.wuywboot.mapper.ParkingMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WuywbootApplicationTests {
    @Autowired
    ParkingMapper parkingMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void test1() {
        parkingMapper.queryAll(null).forEach(System.out::println);
    }
}
