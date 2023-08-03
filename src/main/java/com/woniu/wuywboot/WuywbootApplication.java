package com.woniu.wuywboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.woniu.wuywboot.mapper")
@SpringBootApplication
public class WuywbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuywbootApplication.class, args);
    }

}
