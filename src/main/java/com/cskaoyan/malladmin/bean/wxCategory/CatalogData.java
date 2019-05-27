package com.cskaoyan.malladmin.bean.wxCategory;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:00
 */
public class CatalogData {
    private List<WxCategory> categoryList;
    private WxCategory currentCategory;
    private List<WxCategory> currentSubCategory;

    public CatalogData() {
    }

    public CatalogData(List<WxCategory> categoryList, WxCategory currentCategory, List<WxCategory> currentSubCategory) {
        this.categoryList = categoryList;
        this.currentCategory = currentCategory;
        this.currentSubCategory = currentSubCategory;
    }

    @Override
    public String toString() {
        return "CatalogData{" +
                "categoryList=" + categoryList +
                ", currentCategory=" + currentCategory +
                ", currentSubCategory=" + currentSubCategory +
                '}';
    }

    public List<WxCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<WxCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public WxCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(WxCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<WxCategory> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<WxCategory> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }
}
