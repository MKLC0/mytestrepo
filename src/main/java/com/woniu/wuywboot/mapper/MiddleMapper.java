package com.woniu.wuywboot.mapper;

import org.apache.ibatis.annotations.Param;

public interface MiddleMapper {
    void add(@Param("menuId") int menuId, @Param("userId") int userId);
}
