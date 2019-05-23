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

import java.util.Date;
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

    @Override
    public QueryVo deleteBrand(Brand brand) {

        QueryVo queryVo = new QueryVo();

        Date date = new Date();
        brand.setUpdateTime(date);

        int isDelete = brandMapper.deleteBrand(brand);

        if (isDelete == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;
    }

    @Override
    public QueryVo createBrand(Brand brand) {
        QueryVo queryVo = new QueryVo();

        Date date = new Date();

        brand.setUpdateTime(date);
        brand.setAddTime(date);

        int isCreate = brandMapper.createBrand(brand);

        if (isCreate ==1){
            queryVo.setErrmsg("success");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrno(605);
            queryVo.setErrmsg("failed");
        }

        return queryVo;
    }

    @Override
    public QueryVo updateBrand(Brand brand) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        brand.setUpdateTime(date);
        int isUpdate = brandMapper.updateBrand(brand);

        if (isUpdate==1){
            queryVo.setErrmsg("success");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrno(605);
            queryVo.setErrmsg("failed");
        }

        return queryVo;

    }
}
