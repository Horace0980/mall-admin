package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserRegister;
import com.cskaoyan.malladmin.service.user.UserService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author: Qiu
 * @Date: 2019/5/28 10:46
 */
@RestController
public class WxLoginController {

    @Autowired
    UserService userService;

    @RequestMapping("wx/auth/register")
    public QueryVo register(@RequestBody UserRegister user,HttpServletRequest request){
        String attribute = String.valueOf(request.getSession().getServletContext().getAttribute("code"));

        QueryVo register = new QueryVo();
        if (attribute.equals(user.getCode())){

            User userInfo = userService.register(user,request.getRemoteAddr());
            if (userInfo != null){
                HashMap<Object, Object> map = new HashMap<>();
                map.put("userInfo",userInfo);
                register = new QueryVo(0,map,"注册成功");
                request.getSession().getServletContext().removeAttribute("code");
            }else {
                register = new QueryVo(605,null,"注册失败");
            }

        }else {
            register = new QueryVo(605,null,"验证码错误");
        }




        return register;
    }

    @RequestMapping("wx/user/index")
    public QueryVo index(HttpServletRequest request){
        String ip = request.getRemoteAddr();

        QueryVo index = userService.index(ip);


        return index;
    }
    @RequestMapping("wx/auth/login")
    public QueryVo login(@RequestBody User user,HttpServletRequest request){

        String ip = request.getRemoteAddr();
        User userInfo = userService.login(user,ip);
        if (userInfo != null){
            HashMap<Object, Object> map = new HashMap<>();
            map.put("userInfo",userInfo);
            return new QueryVo(0,map,"success");
        }else {
            return new QueryVo(605,null,"failed");
        }


    }

}
