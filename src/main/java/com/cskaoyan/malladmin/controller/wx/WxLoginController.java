package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserRegister;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Qiu
 * @Date: 2019/5/28 10:46
 */
@RestController
public class WxLoginController {

    @RequestMapping("wx/auth/register")
    public QueryVo register(@RequestBody UserRegister user,HttpServletRequest request){
        String attribute = String.valueOf(request.getSession().getAttribute("code"));

        System.out.println(user.getMobile());

        System.out.printf(attribute+"----"+user.getCode());


        return null;
    }

}
