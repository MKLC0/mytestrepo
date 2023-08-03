package com.woniu.wuywboot.service;


import com.woniu.wuywboot.entity.User;

public interface UserService {
    User login(User user);
    Integer getCountByAccount(String account);
}
