package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.goods.GoodsSpecification;
import com.cskaoyan.malladmin.bean.goods.OrderGoods;
import com.cskaoyan.malladmin.bean.goods.OrderGoodsExample;
import com.cskaoyan.malladmin.bean.market.Order;
import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsSpecificationMapper;
import com.cskaoyan.malladmin.mapper.goods.OrderGoodsMapper;
import com.cskaoyan.malladmin.mapper.market.OrderMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.market.OrderService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 11:11
 */
@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  OrderMapper orderMapper;
  @Autowired
  UserMapper userMapper;
  @Autowired
  OrderGoodsMapper orderGoodsMapper;


  @Override
  public QueryVo getOrderList(QueryIn queryIn, String userId, String orderSn, String orderStatusArray) {
    List<String> statusList = null;
    if (orderStatusArray != null) {
      statusList = getStatusList(orderStatusArray);
    }
    if (userId != null) {
      userId = "%" + userId + "%";

    }
    if (orderSn != null) {
      orderSn = "%" + orderSn + "%";
    }
    HashMap<String, Object> map = new HashMap<>();
    int total = orderMapper.getOrderListCount(userId, orderSn, statusList);
    map.put("total", total);


    if (total % queryIn.getLimit() == 0) {
      map.put("pages", total / queryIn.getLimit());

    } else {
      map.put("pages", total / queryIn.getLimit() + 1);

    }

    map.put("page", queryIn.getPage());
    map.put("limit", queryIn.getLimit());

    PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
    List<Order> orders = orderMapper.getOrderList(userId, orderSn, statusList);


    map.put("items", orders);


    return new QueryVo(0, map, "成功");
  }

  @Override
  public QueryVo getOrderDetail(int id) {
    Order order = orderMapper.getOrderDetail(id);

    HashMap<String, Object> map = new HashMap<>();
    map.put("order", order);
    int userId = order.getUserId();
    User user = userMapper.queryUserById(userId);
    map.put("user",user);
    OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
    OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
    criteria.andOrderIdEqualTo(order.getId());
    List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);

    map.put("orderGoods",orderGoods);



    return new QueryVo(0, map, "success");
  }

  private List<String> getStatusList(String orderStatusArray) {
    String[] strings = new String[]{"101", "102", "103", "201", "202", "203", "301", "402", "401"};
    List<String> status = new ArrayList<>();
    for (int i = 0; i < orderStatusArray.length() - 2; i++) {
      String statu = orderStatusArray.substring(i, i + 3);
      for (int j = 0; j < 9; j++) {
        String string = strings[j];
        if (string.equals(statu)) {
          status.add(statu);
          break;
        }
      }
    }

    return status;
  }
}
