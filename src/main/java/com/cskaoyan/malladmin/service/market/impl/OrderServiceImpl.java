package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.mapper.market.OrderMapper;
import com.cskaoyan.malladmin.service.market.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 11:11
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
}
