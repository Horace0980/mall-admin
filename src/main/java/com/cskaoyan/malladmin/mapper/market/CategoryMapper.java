package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Category;

import java.util.List;
import java.util.Set;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:25
 */
public interface CategoryMapper {

    List<Category> getList(int pid);

    int deleteCategory(Category category);

    int createCategory(Category category);

    int updateCategory(Category category);

    Category selectById(int id);

    List<Category> selectByIdIn(Set<Integer> category_ids);
}
