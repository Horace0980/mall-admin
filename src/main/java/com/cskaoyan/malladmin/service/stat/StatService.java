package com.cskaoyan.malladmin.service.stat;

import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/23 20:27
 */
public interface StatService {
    List<Map> countUsers();
    List<Map> countOrders();
    List<Map> countGoods();
}
