package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.service.market.OrderService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        System.out.printf(userId+"----"+orderSn+"----"+orderStatusArray);

        String substring = orderStatusArray.substring(1, orderStatusArray.length() - 1);
        System.out.printf("-----"+substring);

        return null;
    }
}
