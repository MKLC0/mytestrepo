package com.woniu.wuywboot.web;

import com.woniu.wuywboot.entity.Test;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("test/{id}")
    public void test(Test test, @PathVariable("id") Integer id){
        System.out.println(test);
        System.out.println(id);
    }
}
