package com.cskaoyan.malladmin.service.stat.impl;

import com.cskaoyan.malladmin.mapper.stat.StatMapper;
import com.cskaoyan.malladmin.service.stat.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/23 20:29
 */

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    StatMapper statMapper;

    @Override
    public List<Map> countUsers(){
        return statMapper.countUsers();
    }

    @Override
    public List<Map> countOrders(){
        return statMapper.countOrders();
    }

    @Override
    public List<Map> countGoods(){
        return statMapper.countGoods();
    }
}
