package com.cskaoyan.malladmin.controller.system;

import com.cskaoyan.malladmin.bean.system.GoodCount;
import com.cskaoyan.malladmin.bean.system.OrderCount;
import com.cskaoyan.malladmin.bean.system.UserCount;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author:ZCH
 * @Date:2019/5/22 21:51
 */

@RestController
@RequestMapping("stat")
public class StatController {

    @RequestMapping("user")
    public QueryVo user(){
        String[] columns = {"day", "users"};
        UserCount[] userCounts = {new UserCount("2019-04-19", 22)};
        return basicCountQueryVo(columns, userCounts);
    }

    @RequestMapping("order")
    public QueryVo order(){
        String[] columns = {"day", "orders", "customers", "amount", "pcr"};
        OrderCount orderCount1 = new OrderCount(5227,1,"2019-05-21", 3, 5227);
        OrderCount orderCount2 = new OrderCount(2017,1,"2019-05-22", 1, 2017);
        OrderCount[] orderCounts = {orderCount1, orderCount2};
        return basicCountQueryVo(columns,orderCounts);
    }

    @RequestMapping("goods")
    public QueryVo goods(){
        String[] columns = {"day", "orders", "products", "amount"};
        GoodCount goodCount1 = new GoodCount(5227, "2019-05-21", 3, 3);
        GoodCount goodCount2 = new GoodCount(2067, "2019-05-22", 1, 5);
        GoodCount[] goodCounts = {goodCount1, goodCount2};
        return basicCountQueryVo(columns,goodCounts);
    }

    public QueryVo basicCountQueryVo(String[] columns, Object rows){
        HashMap<String, Object> map = new HashMap<>();
        map.put("columns", columns);
        map.put("rows", rows);
        return new QueryVo(0, map,"成功");
    }
}
