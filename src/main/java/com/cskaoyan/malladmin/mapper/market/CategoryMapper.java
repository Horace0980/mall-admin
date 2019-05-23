package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Category;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:25
 */
public interface CategoryMapper {

    List<Category> getList(int pid);
}
