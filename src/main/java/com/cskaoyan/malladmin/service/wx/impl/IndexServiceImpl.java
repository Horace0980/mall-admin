package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.goods.GoodsExample;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.service.wx.IndexService;
import com.cskaoyan.malladmin.vo.QueryVo;
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
    GoodsMapper goodsMapper;



    @Override
    public QueryVo wxHome() {
        HashMap<Object, Object> map = new HashMap<>();

        List<Brand> brandList = getBrands();

        map.put("brandList",brandList);

        List<Category>  channel= categoryMapper.getList(0);

        map.put("channel",channel);

        List<Category> floorGoodsList = getCategories(channel);


        map.put("floorGoodsList",floorGoodsList);



        return new QueryVo(0,map,"success");
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
