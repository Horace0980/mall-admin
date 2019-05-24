package com.cskaoyan.malladmin.service.market;

import com.cskaoyan.malladmin.bean.goods.Comment;
import com.cskaoyan.malladmin.bean.market.Order;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 11:11
 */
public interface OrderService {
    QueryVo getOrderList(QueryIn queryIn, String userId, String orderSn, String orderStatusArray);

    Order getOrderDetail(int parseInt);

    QueryVo reply(int id, String content);
}
