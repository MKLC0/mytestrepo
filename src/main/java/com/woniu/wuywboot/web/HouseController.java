package com.woniu.wuywboot.web;

import com.woniu.wuywboot.QO.HouseQO;
import com.woniu.wuywboot.entity.House;
import com.woniu.wuywboot.service.BuildingService;
import com.woniu.wuywboot.service.HouseService;
import com.woniu.wuywboot.utils.PageBean;
import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    BuildingService buildingService;
    @Resource
    HouseService houseService;

    @RequestMapping("list")
    public ResponseResult<PageBean<House>> list(HouseQO houseQO,Integer page, Integer pageSize) {
        PageBean<House> houses = houseService.getAll(houseQO, page, pageSize);
        ResponseResult<PageBean<House>> pageBeanResponseResult = new ResponseResult<>();
        pageBeanResponseResult.setData(houses);
        pageBeanResponseResult.setCode(200);
        pageBeanResponseResult.setMsg("ok");
        return pageBeanResponseResult;
    }

    @Value("${wuye.uploadpath}")
    private String uploadPath;

    @RequestMapping("add")
    public ResponseResult<String> add(@RequestBody House house) {
        System.out.println(house);
        houseService.add(house);
        ResponseResult<String> stringResponseResult = new ResponseResult<>();
        stringResponseResult.setData("ok");
        stringResponseResult.setCode(200);
        stringResponseResult.setMsg("ok");
        return stringResponseResult;
    }

    @PostMapping("upload")
    public ResponseResult<String> upload(MultipartFile file) {

        String newFileName = UUID.randomUUID().toString().replaceAll("-", "");
        String oriFileName = file.getOriginalFilename();
        String suffix = oriFileName.substring(oriFileName.lastIndexOf("."));

        File dest = new File(uploadPath, newFileName + suffix);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ResponseResult<String> stringResponseResult = new ResponseResult<>();
        stringResponseResult.setData(newFileName + suffix);
        stringResponseResult.setCode(200);
        stringResponseResult.setMsg("ok");
        return stringResponseResult;
    }
}
