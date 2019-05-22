package com.cskaoyan.malladmin.service.ad;

import com.cskaoyan.malladmin.bean.ad.Ad;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: yyc
 * @Date: 2019/5/22 20:00
 */
public interface AdService {
    QueryVo queryConditions(QueryIn queryIn, String name, String content);

    QueryVo addNew(Ad ad);

    QueryVo updateById(Ad ad);

    QueryVo deleteById(Ad ad);
}
