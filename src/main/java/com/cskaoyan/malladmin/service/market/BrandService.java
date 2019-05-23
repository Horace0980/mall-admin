package com.cskaoyan.malladmin.service.market;

import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 16:56
 */
public interface BrandService {
    QueryVo queryBrandList(QueryIn queryIn, String id, String name);

    QueryVo deleteBrand(Brand brand);
}
