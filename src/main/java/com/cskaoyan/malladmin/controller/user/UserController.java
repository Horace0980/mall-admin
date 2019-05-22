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

/**
 * @Author: xf
 * @Date: 2019/5/22 21:12
 */
@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public QueryVo selectAllUser(int page,int limit,String order,String sort){
        PageHandler pageHandler=null;
        //pageHandler= userService.selectAllUser(queryIn);

        return new QueryVo(0,pageHandler,"成功");
    }
}
