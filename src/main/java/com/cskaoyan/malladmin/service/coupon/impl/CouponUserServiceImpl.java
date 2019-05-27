package com.cskaoyan.malladmin.service.coupon.impl;

import com.cskaoyan.malladmin.bean.coupon.CouponUser;
import com.cskaoyan.malladmin.bean.coupon.CouponUserExample;
import com.cskaoyan.malladmin.mapper.coupon.CouponUserMapper;
import com.cskaoyan.malladmin.service.coupon.CouponUserService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/23 13:42
 */
@Service
public class CouponUserServiceImpl implements CouponUserService {
    @Autowired
    private CouponUserMapper couponUserMapper;


    @Override
    public QueryVo listUserByCouponId(QueryIn queryIn, int couponId, String userId, String status) {
        CouponUserExample couponUserExample = new CouponUserExample();
        couponUserExample.setOrderByClause(queryIn.getSort()+" "+queryIn.getOrder());
        CouponUserExample.Criteria or = couponUserExample.or().andCouponIdEqualTo(couponId).andDeletedEqualTo(false);
        if (userId!=null && userId.trim().length()>0){
            try {
                or.andUserIdEqualTo(Integer.parseInt(userId));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new QueryVo(402,null,"用户id应为整数数字！");
            }
        }
        if (status!=null && status.trim().length()>0){
            try {
                or.andStatusEqualTo(Short.parseShort(status));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new QueryVo(402,null,"状态码应为数字！");
            }
        }
        long l = couponUserMapper.countByExample(couponUserExample);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",couponUsers);
        map.put("total",l);
        return new QueryVo(0,map,"成功");

    }
}
