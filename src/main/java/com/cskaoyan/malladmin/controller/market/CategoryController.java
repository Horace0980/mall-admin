package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.service.market.CategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:24
 */
@RestController
@RequestMapping("admin/category")
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

    @RequestMapping("delete")
    public QueryVo deleteCategory(@RequestBody Category category){
        QueryVo deleteCategory = categoryService.deleteCategory(category);
        return deleteCategory;
    }

    @RequestMapping("create")
    public QueryVo createCategory(@RequestBody Category category){
        QueryVo createCategory = categoryService.createCategory(category);
        return createCategory;
    }
    @RequestMapping("update")
    public QueryVo updateCategory(@RequestBody Category category){
        QueryVo updateCategory = categoryService.updateCategory(category);
        return updateCategory;
    }
}
