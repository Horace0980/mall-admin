package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.bean.market.Order;
import com.cskaoyan.malladmin.service.market.OrderService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 11:10
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("list")
    public QueryVo getOrderList(QueryIn queryIn, String userId, String orderSn,  String orderStatusArray){




       QueryVo getOrderList = orderService.getOrderList(queryIn,userId,orderSn,orderStatusArray);



        return getOrderList;
    }
    @RequestMapping("detail")
    public Order getOrderDetail(String id){
        Order getOrderDetail = orderService.getOrderDetail(Integer.parseInt(id));
        return getOrderDetail;
    }
}
