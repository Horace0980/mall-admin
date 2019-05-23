package com.cskaoyan.malladmin.service.market;

import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:25
 */
public interface CategoryService {
    QueryVo getLevelOne();

    QueryVo queryCategoryList();
}
