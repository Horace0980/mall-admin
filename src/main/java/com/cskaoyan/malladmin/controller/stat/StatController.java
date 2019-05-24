package com.cskaoyan.malladmin.controller.stat;

import com.cskaoyan.malladmin.bean.stat.CountVo;
import com.cskaoyan.malladmin.service.stat.StatService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/22 21:51
 */

@RestController
@RequestMapping("stat")
public class StatController {

    @Autowired
    StatService statService;

    @RequestMapping("user")
    public QueryVo user(){
        String[] columns = {"day", "users"};
        List<Map> rows = statService.countUsers();
        return basicCountStatVo(columns, rows);
    }

    @RequestMapping("order")
    public QueryVo order(){
        String[] columns = {"day", "orders", "customers", "amount", "pcr"};
        List<Map> rows = statService.countOrders();
        return basicCountStatVo(columns,rows);
    }

    @RequestMapping("goods")
    public QueryVo goods(){
        String[] columns = {"day", "orders", "products", "amount"};
        List<Map> rows = statService.countGoods();
        return basicCountStatVo(columns,rows);
    }

    public QueryVo basicCountStatVo(String[] columns, List<Map> rows){
        CountVo countVo = new CountVo(columns, rows);
        return new QueryVo(0, countVo,"成功");
    }
}
