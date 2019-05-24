package com.cskaoyan.malladmin.service.system.impl;

import com.cskaoyan.malladmin.bean.system.MallSystem;
import com.cskaoyan.malladmin.mapper.system.SystemMapper;
import com.cskaoyan.malladmin.service.system.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:03
 */

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemMapper systemMapper;

    @Override
    public List<MallSystem> selectMallSystemByPrefix(String prefix) {
        String s = "%" + prefix + "%";
        return systemMapper.selectMallSystemByMall(s);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public boolean updateMallSystemBykeyName(Map<String, String> systemMap){
        for (String keyName : systemMap.keySet()) {
            MallSystem mallSystem = new MallSystem();
            mallSystem.setKeyName(keyName);
            mallSystem.setKeyValue(systemMap.get(keyName));
            mallSystem.setUpdateTime(new Date());
            int update = systemMapper.updateMallSystemBykeyName(mallSystem);
            if (update != 1){
                return false;
            }
        }
        return true;
    }
}
