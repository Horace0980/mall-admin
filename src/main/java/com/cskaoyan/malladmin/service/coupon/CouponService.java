package com.cskaoyan.malladmin.service.coupon;

import com.cskaoyan.malladmin.bean.coupon.Coupon;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: yyc
 * @Date: 2019/5/22 21:19
 */
public interface CouponService {
    QueryVo queryConditions(QueryIn queryIn, String name, String type, String status);

    QueryVo addNew(Coupon coupon);

    QueryVo getCouponById(String id);

    QueryVo updateCoupon(Coupon coupon);

    QueryVo deleteCoupon(Coupon coupon);
}
