package com.cskaoyan.malladmin.service.coupon;

import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: yyc
 * @Date: 2019/5/23 13:42
 */
public interface CouponUserService {
    QueryVo listUserByCouponId(QueryIn queryIn, int couponId, String userId, String status);
}
