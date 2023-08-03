package com.woniu.wuywboot.web;

import com.woniu.wuywboot.entity.Owner;
import com.woniu.wuywboot.service.OwnerService;
import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("owner")
public class OwnerController {
    @Resource
    OwnerService ownerService;
    @RequestMapping("all")
    public ResponseResult<List<Owner>> all(){
        List<Owner> owners = ownerService.selectAll();
        ResponseResult<List<Owner>> listResponseResult = new ResponseResult<>();
        listResponseResult.setMsg("ok");
        listResponseResult.setCode(200);
        listResponseResult.setData(owners);
        return listResponseResult;
    }
}
