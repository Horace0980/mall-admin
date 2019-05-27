package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.service.wx.IndexService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @Override
    public QueryVo wxHome() {
        HashMap<Object, Object> map = new HashMap<>();
//        List<Brand> brandList = brandMapper.getBrandList();
//        map.put("brandList",brandList);
        List<Category> list = categoryMapper.getList(0);
        map.put("channel",list);



        return new QueryVo(0,map,"success");
    }
}
