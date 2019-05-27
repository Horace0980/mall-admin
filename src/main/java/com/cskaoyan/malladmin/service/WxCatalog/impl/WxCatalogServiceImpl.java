package com.cskaoyan.malladmin.service.WxCatalog.impl;

import com.cskaoyan.malladmin.bean.wxCategory.CatalogData;
import com.cskaoyan.malladmin.bean.wxCategory.WxCategory;
import com.cskaoyan.malladmin.mapper.WxCatalog.WxCatalogMapper;
import com.cskaoyan.malladmin.service.WxCatalog.WxCatalogService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:33
 */
@Service
public class WxCatalogServiceImpl implements WxCatalogService {

    @Autowired
    WxCatalogMapper wxCatalogMapper;
    @Override
    public QueryVo queryIndex() {
        List<WxCategory> categoryList = wxCatalogMapper.queryCategoryList();
        WxCategory currentCategory = wxCatalogMapper.queryCurrentCategory();
        List<WxCategory> subCategory = wxCatalogMapper.querySubCategory();

        QueryVo queryVo = new QueryVo();
        CatalogData catalogData = new CatalogData();
        catalogData.setCategoryList(categoryList);
        catalogData.setCurrentCategory(currentCategory);
        catalogData.setCurrentSubCategory(subCategory);

        queryVo.setData(catalogData);
        queryVo.setErrmsg("成功");
        queryVo.setErrno(0);
        return queryVo;
    }
}
