package com.cskaoyan.malladmin.controller.wx;


import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.service.wx.WxBrandService;
import com.cskaoyan.malladmin.service.wx.WxxCategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: yyc
 * @Date: 2019/5/27 16:17
 */
@RestController
@RequestMapping("wx/goods")
public class WxxCategoryController {
    @Autowired
    WxxCategoryService categoryService;
    @Autowired
    WxBrandService wxBrandService;

    @RequestMapping("category")
    public QueryVo Categoryall(String id){
        return categoryService.getById(id);
    }

    @RequestMapping("list")
    public QueryVo categoryList(String categoryId, String brandId, String page,String size,String keyword,String sort,String order){
        if ((keyword==null || keyword.trim().length()==0) && categoryId != null){
            return categoryService.getGoodsListInPage(categoryId,page,size);
        }else if ((keyword==null || keyword.trim().length()==0) && brandId != null){
            HashMap<String, Object> map = new HashMap<>();
            Category[] filterCategoryList = new Category[0];
            Goods[] goodsList = new Goods[0];
            map.put("count",0);
            map.put("filterCategoryList",filterCategoryList);
            map.put("goodsList",goodsList);
            QueryVo queryVo = new QueryVo(0, map, "成功");
            return queryVo;
        }
        return categoryService.getGoodsListInPageByKeyword(keyword,sort,order,page,size);
    }


}
