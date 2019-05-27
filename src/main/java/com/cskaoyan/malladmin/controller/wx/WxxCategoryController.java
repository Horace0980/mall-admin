package com.cskaoyan.malladmin.controller.wx;


import com.cskaoyan.malladmin.service.wx.WxxCategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc
 * @Date: 2019/5/27 16:17
 */
@RestController
@RequestMapping("wx/goods")
public class WxxCategoryController {
    @Autowired
    WxxCategoryService categoryService;
    @RequestMapping("category")
    public QueryVo Categoryall(String id){
        return categoryService.getById(id);
    }

    @RequestMapping("list")
    public QueryVo categoryList(String categoryId,String page,String size,String keyword,String sort,String order){
        if (keyword==null || keyword.trim().length()==0)
            return categoryService.getGoodsListInPage(categoryId,page,size);
        return categoryService.getGoodsListInPageByKeyword(keyword,sort,order,page,size);
    }


}
