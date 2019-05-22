package com.cskaoyan.malladmin.service.system.impl;

import com.cskaoyan.malladmin.bean.system.MallSystem;
import com.cskaoyan.malladmin.mapper.system.SystemMapper;
import com.cskaoyan.malladmin.service.system.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:03
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemMapper systemMapper;

    @Override
    public List<MallSystem> selectMallConfigByPrefix(String prefix) {
        String s = "%" + prefix + "%";
        return systemMapper.selectMallSystemByMall(s);
    }
}
