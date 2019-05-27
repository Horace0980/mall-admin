package com.cskaoyan.malladmin.controller.utils;

import com.cskaoyan.malladmin.bean.coupon.Coupon;
import com.cskaoyan.malladmin.service.coupon.CouponService;
import com.cskaoyan.malladmin.service.coupon.CouponUserService;
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
@RequestMapping("admin/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponUserService couponUserService;
    @RequestMapping("list")
    public QueryVo list(QueryIn queryIn,String name,String type,String status){
        return couponService.queryConditions(queryIn,name,type,status);
    }

    @RequestMapping("create")
    public QueryVo addNew(@RequestBody Coupon coupon){

        return couponService.addNew(coupon);
    }
    @RequestMapping("read")
    public QueryVo getCouponById(String id){
        return couponService.getCouponById(id);
    }
    @RequestMapping("listuser")
    public QueryVo getCouponUserByCouponId(QueryIn queryIn,int couponId,String userId,String status){
        return couponUserService.listUserByCouponId(queryIn,couponId,userId,status);
    }
    @RequestMapping("update")
    public QueryVo updateCoupon(@RequestBody Coupon coupon){
        return couponService.updateCoupon(coupon);
    }
    @RequestMapping("delete")
    public QueryVo deleteCoupon(@RequestBody Coupon coupon){
        return couponService.deleteCoupon(coupon);
    }




}
