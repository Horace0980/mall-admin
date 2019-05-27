package com.cskaoyan.malladmin.service.wx;

import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: yyc
 * @Date: 2019/5/27 16:26
 */

public interface WxxCategoryService {
    QueryVo getById(String id);

    QueryVo getGoodsListInPage(String categoryId, String page, String size);

    QueryVo getGoodsListInPageByKeyword(String keyword, String sort, String order, String page, String size);

}
