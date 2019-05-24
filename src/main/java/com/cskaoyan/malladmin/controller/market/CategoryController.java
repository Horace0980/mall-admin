package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.service.market.CategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:24
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("l1")
    public QueryVo getLevelOne(){
        QueryVo getLevelOne = categoryService.getLevelOne();
        return getLevelOne;
    }

    @RequestMapping("list")
    public QueryVo queryCategoryList(){
        QueryVo queryCategoryList = categoryService.queryCategoryList();
        return queryCategoryList;
    }
}
