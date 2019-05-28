package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.service.wx.WxBrandService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/5/27 22:31
 */
@Service
public class WxBrandServiceImpl implements WxBrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public Brand selectBrandById(String id){

        Brand brand = brandMapper.selectBrandById(Integer.parseInt(id));

        return brand;
    }
}
