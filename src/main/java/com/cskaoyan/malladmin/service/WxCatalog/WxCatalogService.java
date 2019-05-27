package com.cskaoyan.malladmin.service.WxCatalog;

import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:31
 */
public interface WxCatalogService {
    QueryVo queryIndex();

    QueryVo current(int id);
}
