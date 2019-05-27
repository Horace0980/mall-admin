package com.cskaoyan.malladmin.mapper.WxCatalog;

import com.cskaoyan.malladmin.bean.wxCategory.WxCategory;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:34
 */
public interface WxCatalogMapper {
    List<WxCategory> queryCategoryList();
    WxCategory queryCurrentCategory();
    List<WxCategory> querySubCategory();
}
