package com.cskaoyan.malladmin.service.market;

import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:25
 */
public interface CategoryService {
    QueryVo getLevelOne();

    QueryVo queryCategoryList();

    QueryVo deleteCategory(Category category);

    QueryVo createCategory(Category category);

    QueryVo updateCategory(Category category);
}
