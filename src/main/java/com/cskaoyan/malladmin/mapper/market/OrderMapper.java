package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 11:11
 */
public interface OrderMapper {
    int getOrderListCount(String userId, String orderSn, List<String> statusList);

    List<Order> getOrderList(@Param("userId")String userId, @Param("orderSn") String orderSn, List<String> statusList);

    Order getOrderDetail(int id);

  int getOrderTotal();
}
