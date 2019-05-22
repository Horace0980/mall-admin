package com.cskaoyan.malladmin.controller;

import com.cskaoyan.malladmin.mapper.admin.AdminMapper;
import com.cskaoyan.malladmin.service.ad.AdService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc
 * @Date: 2019/5/22 19:46
 */
@RestController
@RequestMapping("ad")
public class AdController {
    @Autowired
    private AdService adService;

    @RequestMapping("list")
    public QueryVo query(QueryIn queryIn,String name,String content){
        return adService.queryConditions(queryIn,name,content);
    }



}
