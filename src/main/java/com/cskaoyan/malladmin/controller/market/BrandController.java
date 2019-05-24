package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.bean.Image;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.service.market.BrandService;
import com.cskaoyan.malladmin.utils.UploadUtils;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

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
    @RequestMapping("delete")
    public QueryVo deleteBrand(@RequestBody Brand brand){
        QueryVo deleteBrand = brandService.deleteBrand(brand);
        return deleteBrand;
    }

    @RequestMapping("create")
    public QueryVo createBrand(@RequestBody Brand brand) {
        QueryVo queryVo = new QueryVo();

        queryVo = brandService.createBrand(brand);
        return queryVo;
    }
    @RequestMapping("update")
    public QueryVo updateBrand(@RequestBody Brand brand){

        QueryVo updateBrand = brandService.updateBrand(brand);
        return updateBrand;
    }

}
