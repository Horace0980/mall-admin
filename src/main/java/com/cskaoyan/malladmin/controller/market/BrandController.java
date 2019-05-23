package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.service.market.BrandService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 16:53
 */

@RequestMapping("brand")
@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("list")
    public QueryVo queryBrandList(QueryIn queryIn,String id,String name){

        QueryVo queryBrandList = brandService.queryBrandList(queryIn,id,name);

        return queryBrandList;

    }

}
