package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.service.market.BrandService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 16:56
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public QueryVo queryBrandList(QueryIn queryIn, String id, String name) {


        HashMap<String, Object> map = new HashMap<>();
        if (id!=null){
            id = "%"+ id+"%";
        }
        if (name != null){
            name = "%"+name+"%";
        }
        int total = brandMapper.queryBrandListCount(id,name);

        map.put("total",total);


        if (total%queryIn.getLimit() == 0){
            map.put("pages",total/queryIn.getLimit());

        }else {
            map.put("pages",total/queryIn.getLimit()+1);

        }

        map.put("page",queryIn.getPage());
        map.put("limit",queryIn.getLimit());

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Brand> brands = brandMapper.queryBrandList(id,name);

        map.put("items",brands);


        return new QueryVo(0,map,"成功");


    }
}