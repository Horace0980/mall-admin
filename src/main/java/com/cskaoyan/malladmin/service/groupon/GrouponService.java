package com.cskaoyan.malladmin.service.groupon;

import com.cskaoyan.malladmin.bean.groupon.GrouponRules;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: yyc
 * @Date: 2019/5/23 17:32
 */
public interface GrouponService {
    QueryVo getInCondition(QueryIn queryIn, String goodsId);

    QueryVo addNew(GrouponRules grouponRules);

    QueryVo update(GrouponRules grouponRules);

    QueryVo delete(GrouponRules grouponRules);

    QueryVo getGrouponInCondition(QueryIn queryIn, String goodsId);
}
