package com.cskaoyan.malladmin.controller;

import com.cskaoyan.malladmin.bean.coupon.Coupon;
import com.cskaoyan.malladmin.service.coupon.CouponService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: yyc
 * @Date: 2019/5/22 21:17
 */
@RestController
@RequestMapping("coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @RequestMapping("list")
    public QueryVo list(QueryIn queryIn,String name,String type,String status){
        return couponService.queryConditions(queryIn,name,type,status);
    }

    @RequestMapping("create")
    public QueryVo addNew(@RequestBody Coupon coupon){

        return couponService.addNew(coupon);
    }



}
