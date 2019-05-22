package com.cskaoyan.malladmin.controller;

import com.cskaoyan.malladmin.bean.admin.Admin;
import com.cskaoyan.malladmin.service.admin.AdminService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: yyc
 * @Date: 2019/5/22 13:18
 */
@RestController
@RequestMapping("auth")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("login")
    public QueryVo login(@RequestBody Admin admin, HttpServletRequest request){
        QueryVo login = adminService.login(admin,request);
        return login;
    }

    @RequestMapping("info")
    public QueryVo toInfo(String token,HttpServletRequest request){
        HttpSession session = request.getSession();

        String token1 = (String) session.getAttribute("token");
//        if (token1==null || !token1.equals(token)){
//            return new QueryVo(0,null,"please Log in");
//        }
        Admin admin = (Admin) session.getAttribute("admin");
        return adminService.getInfo(admin);
    }
}
