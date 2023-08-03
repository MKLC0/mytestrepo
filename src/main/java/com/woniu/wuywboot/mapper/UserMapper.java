package com.woniu.wuywboot.mapper;


import com.woniu.wuywboot.entity.User;

import java.util.List;

public interface UserMapper {
    void add(User user);
    void update(User user);
    void delete(Integer id);
    List<User> select(Integer id);
    User queryById(Integer id);
    User queryByAccount(String account);
}
