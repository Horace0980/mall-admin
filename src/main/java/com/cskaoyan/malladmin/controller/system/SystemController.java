package com.cskaoyan.malladmin.controller.system;

import com.cskaoyan.malladmin.bean.system.MallSystem;
import com.cskaoyan.malladmin.service.system.SystemService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * @Author:ZCH
 * @Date:2019/5/22 21:01
 */

@RestController
@RequestMapping("admin/config")
public class SystemController {

    @Autowired
    SystemService systemService;

    /*--------------------------------以下是查看功能--------------------------------*/

    /**
     * 这是根据数据库中的cskaoyan_mall_mall前缀来返回商场配置的对应的数据
     * @return 商场配置所需要的数据
     */
    @GetMapping(value = "mall")
    public QueryVo findMall(){
        return basic("cskaoyan_mall_mall");
    }

    /**
     * 这是根据数据库中的cskaoyan_mall_express前缀来返回运费配置的对应的数据
     * @return 运费配置所需要的数据
     */
    @GetMapping(value = "express")
    public QueryVo findExpress(){
        return basic("cskaoyan_mall_express");
    }

    /**
     * 这是根据数据库中的cskaoyan_mall_order前缀来返回运费配置的对应的数据
     * @return 订单配置所需要的数据
     */
    @GetMapping(value = "order")
    public QueryVo findOrder(){
        return basic("cskaoyan_mall_order");
    }

    /**
     * 这是根据数据库中的cskaoyan_mall_wx前缀来返回小程序配置的对应的数据
     * @return 小程序配置所需要的数据
     */
    @GetMapping(value = "wx")
    public QueryVo findWx(){
        return basic("cskaoyan_mall_wx");
    }

    public QueryVo basic(String prefix){
        Map<String, String> systemMap = new HashMap<>();
        List<MallSystem> mall = systemService.selectMallSystemByPrefix(prefix);
        for (MallSystem mallSystem : mall) {
            systemMap.put(mallSystem.getKeyName(), mallSystem.getKeyValue());
        }
        QueryVo queryVo = new QueryVo();
        queryVo.setData(systemMap);
        queryVo.setErrmsg("成功");
        queryVo.setErrno(0);
        return queryVo;
    }

    /*--------------------------------以下是修改功能--------------------------------*/
    @PostMapping("mall")
    public QueryVo updateMall(@RequestBody Map<String, String> systemMap){
        return basicUpdate(systemMap);
    }

    @PostMapping("express")
    public QueryVo updateExpress(@RequestBody Map<String, String> systemMap){
        return basicUpdate(systemMap);
    }

    @PostMapping("order")
    public QueryVo updateOrder(@RequestBody Map<String, String> systemMap){
        return basicUpdate(systemMap);
    }

    @PostMapping("wx")
    public QueryVo updateWx(@RequestBody Map<String, String> systemMap){
        return basicUpdate(systemMap);
    }

    public QueryVo basicUpdate(Map<String, String> systemMap){
        boolean b = systemService.updateMallSystemBykeyName(systemMap);
        QueryVo queryVo = new QueryVo();
        if (b){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("修改失败！");
            queryVo.setErrno(500);
        }
        return queryVo;
    }

}
