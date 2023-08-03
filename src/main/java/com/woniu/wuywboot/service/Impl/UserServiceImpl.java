package com.woniu.wuywboot.service.Impl;

import com.woniu.wuywboot.entity.User;
import com.woniu.wuywboot.mapper.UserMapper;
import com.woniu.wuywboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        User user1 = userMapper.queryByAccount(user.getAccount());

        if (user1 == null) return null;
        if (user.getPassword().equals(user1.getPassword())) {
            return user1;
        }
        return null;
    }

    @Override
    public Integer getCountByAccount(String account) {
        return null;
    }
}
