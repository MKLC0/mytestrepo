package com.woniu.wuywboot.ExcepionHandle;

import com.woniu.wuywboot.utils.ResponseResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestControllerAdvice(basePackages = "com.woniu.wuywboot.web")
public class ExceptionHandle {
    @ExceptionHandler
    public ResponseResult<?> handleException(MethodArgumentNotValidException e) {
        Map<String, String> hashMap = new HashMap<>();
        List<FieldError> fieldErrors = e.getFieldErrors();
        fieldErrors.forEach(er -> {
            hashMap.put(er.getField(), er.getDefaultMessage());
        });
        ResponseResult<Map<String, String>> result = new ResponseResult<>();
        result.setCode(501);
        result.setData(hashMap);
        result.setMsg("fail");
        return result;
    }

    @ExceptionHandler
    public ResponseResult<String> handleException(Exception e) {
        System.out.println(e);
        e.printStackTrace();
//        return ResponseResult.fail(null);
        ResponseResult<String> result = new ResponseResult<>();
        result.setMsg("fail");
        result.setCode(502);
        return result;
    }
}
