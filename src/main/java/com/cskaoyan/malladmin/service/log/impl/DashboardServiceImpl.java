package com.cskaoyan.malladmin.service.log.impl;

import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsProductMapper;
import com.cskaoyan.malladmin.mapper.market.OrderMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.log.DashboardService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 16:16
 */
@Service
public class DashboardServiceImpl implements DashboardService {

  @Autowired
  GoodsMapper goodsMapper;
  @Autowired
  OrderMapper orderMapper;
  @Autowired
  UserMapper userMapper;

  @Autowired
  GoodsProductMapper goodsProductMapper;



  @Override
  public QueryVo dashboard() {

    int orderTotal = orderMapper.getOrderTotal();
    int goodsTotal = goodsMapper.getGoodsTotal();
    int userTotal = userMapper.getUserTotal();
    int productTotal = goodsProductMapper.getProductTotal();

    HashMap<String, Integer> map = new HashMap<>();
    map.put("goodsTotal",goodsTotal);
    map.put("orderTotal",orderTotal);
    map.put("userTotal",userTotal);
    map.put("productTotal",productTotal);

    return new QueryVo(0,map,"success");

  }
}
