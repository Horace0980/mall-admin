package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.bean.ad.Ad;
import com.cskaoyan.malladmin.bean.ad.AdExample;
import com.cskaoyan.malladmin.bean.coupon.Coupon;
import com.cskaoyan.malladmin.bean.coupon.CouponExample;
import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.goods.GoodsExample;
import com.cskaoyan.malladmin.bean.groupon.Groupon;
import com.cskaoyan.malladmin.bean.groupon.GrouponExample;
import com.cskaoyan.malladmin.bean.groupon.GrouponWx;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.bean.topic.Topic;
import com.cskaoyan.malladmin.bean.topic.TopicExample;
import com.cskaoyan.malladmin.mapper.ad.AdMapper;
import com.cskaoyan.malladmin.mapper.coupon.CouponMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.groupon.GrouponMapper;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.mapper.topic.TopicMapper;
import com.cskaoyan.malladmin.service.wx.IndexService;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 16:24
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    AdMapper adMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    GrouponMapper grouponMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    TopicMapper topicMapper;



    @Override
    public QueryVo wxHome() {
        HashMap<Object, Object> map = new HashMap<>();
//        List<Brand> brandList = brandMapper.getBrandList();
//        map.put("brandList",brandList);
        List<Category> list = categoryMapper.getList(0);
        map.put("channel",list);

        //banner
        AdExample adExample = new AdExample();
        PageHelper.startPage(0,4);
        List<Ad> banner = adMapper.selectByExample(adExample);
        map.put("banner",banner);

        //couponList
        CouponExample couponExample = new CouponExample();
        PageHelper.startPage(0,4);
        List<Coupon> couponList = couponMapper.selectByExample(couponExample);
        map.put("couponList",couponList);

        //grouponList
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdBetween(1006002,1006007);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        GrouponWx grouponWx1 = new GrouponWx(goods.get(0), 231, 899.00);
        GrouponWx grouponWx2 = new GrouponWx(goods.get(1), 244, 450.00);
        List<GrouponWx> grouponList = new ArrayList<>();
        grouponList.add(grouponWx1);
        grouponList.add(grouponWx2);
        map.put("grouponList",grouponList);

        //newGoodsList
        List<Goods> newGoodsList = goodsMapper.selectNewGoodsList();
        map.put("newGoodsList",newGoodsList);

        //topicList
        TopicExample topicExample = new TopicExample();
        PageHelper.startPage(0,4);
        List<Topic> topicList = topicMapper.selectByExample(topicExample);
        map.put("topicList",topicList);


        return new QueryVo(0,map,"success");
    }
}
