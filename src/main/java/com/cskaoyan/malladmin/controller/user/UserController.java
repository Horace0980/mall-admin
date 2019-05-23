package com.cskaoyan.malladmin.controller.user;

import com.cskaoyan.malladmin.service.user.UserService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public Map<String ,Object> selectAllUser(QueryIn queryIn){
        PageHandler pageHandler=null;
        pageHandler= userService.selectAllUser(queryIn);
        Map<String ,Object> map=new HashMap<>();
        map.put("errno",0);
        map.put("errmsg","成功");
        map.put("data",pageHandler);
        return map;
    }

}
