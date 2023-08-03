package com.woniu.wuywboot.web;

import com.woniu.wuywboot.entity.Menu;
import com.woniu.wuywboot.entity.User;
import com.woniu.wuywboot.mapper.MenuMapper;
import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    MenuMapper menuMapper;

    @RequestMapping("left")
    public ResponseResult<List<Menu>> left(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        List<Menu> menus = user.getMenus();
        ResponseResult<List<Menu>> listResponseResult = new ResponseResult<>();
        listResponseResult.setCode(200);
        listResponseResult.setMsg("success");
        listResponseResult.setData(menus);
        return listResponseResult;
    }

    @RequestMapping("list")
    public ResponseResult<List<Menu>> list() {
        List<Menu> menus = menuMapper.select();
        List<Menu> parentMenus = new ArrayList<>();
        for (Menu menu : menus) {
            if (menu.getParent() == null) {
                parentMenus.add(menu);//将父菜单(一级菜单)加到List中
                //找到该父菜单的所有子菜单(二级菜单)，加到父菜单的sunMenus中
                for (Menu subMenu : menus) {
                    if (subMenu.getParent() == menu.getMenuId()) {
                        menu.getSubMenu().add(subMenu);
                    }
                }
            }
        }
        ResponseResult<List<Menu>> listResponseResult = new ResponseResult<>();
        listResponseResult.setData(parentMenus);
        listResponseResult.setMsg("ok");
        listResponseResult.setCode(200);
        return listResponseResult;
    }
}
