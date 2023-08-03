package com.woniu.wuywboot.mapper;


import com.woniu.wuywboot.entity.Owner;
import com.woniu.wuywboot.entity.User;

import java.util.List;

public interface OwnerMapper {
    void add(Owner owner);
    void update(Owner owner);
    void delete(Integer id);
    List<Owner> select();
    User queryById(Integer id);
}
