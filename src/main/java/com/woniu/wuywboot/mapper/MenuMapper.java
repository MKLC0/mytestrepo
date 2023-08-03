package com.woniu.wuywboot.mapper;


import com.woniu.wuywboot.VO.UserVO;
import com.woniu.wuywboot.entity.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> select();
    Menu queryById(int id);
    void add(Menu menu);

}
