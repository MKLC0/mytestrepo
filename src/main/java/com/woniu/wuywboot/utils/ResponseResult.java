package com.woniu.wuywboot.utils;

import lombok.Builder;
import lombok.Data;

@Data
public class ResponseResult<T> {
    //响应码，自己规定的
    private int code;
    //消息提示，不是必须的
    private String msg;
    //响应的数据，可能是null
    private T data;
    public static ResponseResult<String> ok(){
        ResponseResult<String> stringResponseResult = new ResponseResult<>();
        stringResponseResult.setMsg("ok");
        stringResponseResult.setCode(200);
        stringResponseResult.setData("success");
        return stringResponseResult;
    }
}
