package com.cskaoyan.malladmin.service.coupon.impl;

import com.cskaoyan.malladmin.bean.coupon.Coupon;
import com.cskaoyan.malladmin.bean.coupon.CouponExample;
import com.cskaoyan.malladmin.mapper.coupon.CouponMapper;
import com.cskaoyan.malladmin.service.coupon.CouponService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/22 21:19
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public QueryVo queryConditions(QueryIn queryIn, String name, String type, String status) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria or = couponExample.or();
        if (name != null && name.trim().length() > 0) {
            or.andNameLike("%" + name + "%");
        }
        if (type != null && type.trim().length() > 0) {
            or.andTypeEqualTo(Short.parseShort(type));
        }
        if (status != null && status.trim().length() > 0) {
            or.andStatusEqualTo(Short.parseShort(status));
        }
        int l = (int) couponMapper.countByExample(couponExample);
        couponExample.setOrderByClause(queryIn.getSort() + " " + queryIn.getOrder());
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        HashMap<String, Object> map = new HashMap<>();
        int limit = queryIn.getLimit();
        map.put("limit", limit);
        map.put("list", coupons);
        map.put("page", queryIn.getPage());
        map.put("pages", l % limit == 0 ? l / limit : (l / limit + 1));
        map.put("total", l);
        return new QueryVo(0, map, "成功");
    }

    @Override
    public QueryVo addNew(Coupon coupon) {
        Date addTime = new Date();
        coupon.setAddTime(addTime);
        coupon.setUpdateTime(addTime);
        coupon.setDeleted(false);
        int i = couponMapper.insertSelective(coupon);

        if (i != 1)
            return new QueryVo(402, null, "插入失败！网络异常！");

        return new QueryVo(0, coupon, "成功");

    }
}
