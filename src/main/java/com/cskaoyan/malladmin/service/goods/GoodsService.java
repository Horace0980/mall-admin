package com.cskaoyan.malladmin.service.goods;

import com.cskaoyan.malladmin.bean.goods.*;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author : zjf
 * @Date : 2019/5/22 下午 11:14
 */
public interface GoodsService {
    QueryVo allList(QueryIn queryIn, Integer goodsSn, String name);

    QueryVo deleteById(Goods goods);

    QueryVo detailById(Integer id);

    QueryVo catAndBrand();

    String getNameById(Integer id);

    QueryVo inserts(BigData bigData);

    QueryVo updates(UpdateData updateData);

    QueryVo indexCount();
}
