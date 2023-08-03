package com.woniu.wuywboot.web;


import com.woniu.wuywboot.VO.UserVO;
import com.woniu.wuywboot.entity.Menu;
import com.woniu.wuywboot.entity.User;
import com.woniu.wuywboot.mapper.MenuMapper;
import com.woniu.wuywboot.mapper.MiddleMapper;
import com.woniu.wuywboot.service.UserService;
import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    MiddleMapper middleMapper;

    @PostMapping("login")
    public ResponseResult<Void> login(@RequestBody User user, HttpSession httpSession) {
        User login = userService.login(user);
        ResponseResult<Void> voidResponseResult = new ResponseResult<>();
        if (login == null) {
            voidResponseResult.setCode(500);
            voidResponseResult.setMsg("failed");
        } else {
            httpSession.setAttribute("user", login);
            voidResponseResult.setCode(200);
            voidResponseResult.setMsg("success!!!!!!!!!!");
        }
        return voidResponseResult;
    }

    @PostMapping("add")
    public ResponseResult<String> add(@RequestBody UserVO userVO) {
        User user = userVO.getUser();
        int[] menuIds = userVO.getMenuIds();
        for (int menuId : menuIds) {
            middleMapper.add(menuId, user.getUserId());
        }
        return ResponseResult.ok();
    }
}
