package com.cskaoyan.malladmin.mapper.stat;

import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/23 20:33
 */
public interface StatMapper {
    List<Map> countUsers();
    List<Map> countOrders();
    List<Map> countGoods();
}
