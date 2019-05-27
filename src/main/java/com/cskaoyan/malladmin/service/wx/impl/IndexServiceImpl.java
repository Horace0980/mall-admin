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
import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.goods.GoodsExample;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.bean.topic.Topic;
import com.cskaoyan.malladmin.bean.topic.TopicExample;
import com.cskaoyan.malladmin.mapper.ad.AdMapper;
import com.cskaoyan.malladmin.mapper.coupon.CouponMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.groupon.GrouponMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
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
import java.util.HashSet;
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

        //brandList
        List<Brand> brandList = getBrands();
        map.put("brandList",brandList);
        //channel
        List<Category>  channel= categoryMapper.getList(0);
        map.put("channel",channel);
        //floorGoodsList
        List<Category> floorGoodsList = getCategories(channel);
        map.put("floorGoodsList",floorGoodsList);

        //banner
        List<Ad> banner = getBanner();
        map.put("banner",banner);

        //couponList
        List<Coupon> couponList = getCouponList();
        map.put("couponList",couponList);

        //grouponList
        List<GrouponWx> grouponList = getGrouponWxes();
        map.put("grouponList",grouponList);

        //newGoodsList
        List<Goods> newGoodsList = goodsMapper.selectNewGoodsList();
        map.put("newGoodsList",newGoodsList);

        //topicList
        List<Topic> topicList = getTopics();
        map.put("topicList",topicList);
        //hotGoodsList

        List<Goods> hotGoodsList = getHotGoodsList();


        map.put("hotGoodsList",hotGoodsList);

        return new QueryVo(0,map,"success");
    }

    private List<Goods> getHotGoodsList() {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        List<Short> list = new ArrayList<>();
        for (int i = 35; i < 40; i++) {
            list.add((short) i);
        }
        criteria.andSortOrderIn(list);
        return goodsMapper.selectByExample(goodsExample);
    }

    private List<Topic> getTopics() {
        TopicExample topicExample = new TopicExample();
        PageHelper.startPage(0,4);
        return topicMapper.selectByExample(topicExample);
    }

    private List<GrouponWx> getGrouponWxes() {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIdBetween(1006002,1006007);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        GrouponWx grouponWx1 = new GrouponWx(goods.get(0), 231, 899.00);
        GrouponWx grouponWx2 = new GrouponWx(goods.get(1), 244, 450.00);
        List<GrouponWx> grouponList = new ArrayList<>();
        grouponList.add(grouponWx1);
        grouponList.add(grouponWx2);
        return grouponList;
    }

    private List<Coupon> getCouponList() {
        CouponExample couponExample = new CouponExample();
        PageHelper.startPage(0,4);
        return couponMapper.selectByExample(couponExample);
    }

    private List<Ad> getBanner() {
        AdExample adExample = new AdExample();
        PageHelper.startPage(0,4);
        return adMapper.selectByExample(adExample);
    }

    private List<Category> getCategories(List<Category> channel) {

        List<Category> floorGoodsList  = new ArrayList<>();

        int[] num1 = new int[]{1005000,1013000,1005001,1005002,1011000,1010000,1008000,1012000,1019000};
        for (int i = 0; i < channel.size(); i++) {
            for (int j = 0; j < num1.length; j++) {
                int id = channel.get(i).getId();
                if (id == num1[j]){
                    List<Category> list = categoryMapper.getList(id);
                    List<Goods> goods = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        GoodsExample goodsExample = new GoodsExample();
                        GoodsExample.Criteria criteria = goodsExample.createCriteria();
                        criteria.andCategoryIdEqualTo(list.get(k).getId());
                        List<Goods> list1 = goodsMapper.selectByExample(goodsExample);
                        if (list1.size() != 0){
                            for (int l = 0; l < list1.size(); l++) {
                                goods.add(list1.get(l));
                            }
                        }
                    }
                    List<Integer> integers = getIntegers(goods, 4);
                    List<Goods> goodsList = new ArrayList<>();
                    for (int k = 0; k < integers.size(); k++) {
                        goodsList.add(goods.get(integers.get(k)));
                    }
                    channel.get(i).setGoodsList(goodsList);
                }
            }
            if (floorGoodsList.size()<4){
                floorGoodsList.add(channel.get(i));
            }else {
                break;
            }
        }

        return floorGoodsList;
    }

    private List<Brand> getBrands() {
        List<Brand> brand = brandMapper.getBrandList();

        List<Integer> nums = getIntegers(brand,4);
        List<Brand> brandList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            brandList.add(brand.get(nums.get(i)));
        }
        return brandList;
    }

    private List<Integer> getIntegers(List<?> list,int number) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int num = (int) (Math.random() * (list.size() - 1)) + 1;
            boolean add = set.add(num);
            if (add){
                nums.add(num);
            }else {

            }
        }
        return nums;
    }
}
