package com.cskaoyan.malladmin.controller.system;

import com.cskaoyan.malladmin.bean.system.MallSystem;
import com.cskaoyan.malladmin.service.system.SystemService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/22 21:01
 */

@RestController
@RequestMapping("config")
public class SystemController {

    @Autowired
    SystemService systemService;

    /**
     * 这是根据数据库中的cskaoyan_mall_mall前缀来返回商场配置的对应的数据
     * @return 商场配置所需要的数据
     */
    @RequestMapping("mall")
    public QueryVo mall(){
        return basic("cskaoyan_mall_mall");
    }

    /**
     * 这是根据数据库中的cskaoyan_mall_express前缀来返回运费配置的对应的数据
     * @return 运费配置所需要的数据
     */
    @RequestMapping("express")
    public QueryVo express(){
        return basic("cskaoyan_mall_express");
    }

    /**
     * 这是根据数据库中的cskaoyan_mall_order前缀来返回运费配置的对应的数据
     * @return 订单配置所需要的数据
     */
    @RequestMapping("order")
    public QueryVo order(){
        return basic("cskaoyan_mall_order");
    }

    /**
     * 这是根据数据库中的cskaoyan_mall_wx前缀来返回小程序配置的对应的数据
     * @return 小程序配置所需要的数据
     */
    @RequestMapping("wx")
    public QueryVo wx(){
        return basic("cskaoyan_mall_wx");
    }

    public QueryVo basic(String prefix){
        Map<String, String> systemMap = new HashMap<>();
        List<MallSystem> mall = systemService.selectMallConfigByPrefix(prefix);
        for (MallSystem mallSystem : mall) {
            systemMap.put(mallSystem.getKeyName(), mallSystem.getKeyValue());
        }
        QueryVo queryVo = new QueryVo();
        queryVo.setData(systemMap);
        queryVo.setErrmsg("成功");
        queryVo.setErrno(0);
        return queryVo;
    }
}
