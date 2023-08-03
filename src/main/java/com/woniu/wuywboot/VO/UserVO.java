package com.woniu.wuywboot.VO;

import com.woniu.wuywboot.entity.User;
import lombok.Data;

@Data
public class UserVO {
    private User user;
    private int[] menuIds;
}
