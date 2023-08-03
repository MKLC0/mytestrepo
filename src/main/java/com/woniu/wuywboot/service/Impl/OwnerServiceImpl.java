package com.woniu.wuywboot.service.Impl;

import com.woniu.wuywboot.entity.Owner;
import com.woniu.wuywboot.mapper.OwnerMapper;
import com.woniu.wuywboot.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerMapper ownerMapper;
    @Override
    public List<Owner> selectAll() {
        return ownerMapper.select();
    }
}
