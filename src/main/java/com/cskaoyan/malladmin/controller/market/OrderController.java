package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.bean.goods.Comment;
import com.cskaoyan.malladmin.bean.market.Order;
import com.cskaoyan.malladmin.service.market.OrderService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Qiu
 * @Date: 2019/5/24 11:10
 */
@RestController
@RequestMapping("admin/order")
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

    @RequestMapping("reply")
    @ResponseBody
    public QueryVo reply(@RequestBody Comment comment){
        int id = Integer.parseInt(comment.getCommentId());
        String content = comment.getContent();
        return orderService.reply(id,content);
    }
}
