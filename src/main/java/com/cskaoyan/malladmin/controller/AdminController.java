package com.cskaoyan.malladmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: yyc
 * @Date: 2019/5/22 13:18
 */
@Controller
@RequestMapping("auth")
public class AdminController {

    @RequestMapping("login")
    public void login(){
        System.out.println("1");
    }
}
