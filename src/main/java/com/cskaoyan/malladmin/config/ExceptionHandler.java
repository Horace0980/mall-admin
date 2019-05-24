package com.cskaoyan.malladmin.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: yyc
 * @Date: 2019/5/23 23:16
 */
@ControllerAdvice(basePackages = "com.cskaoyan.malladmin.controller")
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public Map<String,Object> handleException(Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("errno",402);
        map.put("errmsg","参数异常");
        return map;
    }
}
