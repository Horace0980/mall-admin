package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.service.market.RegionService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:43
 */

@RequestMapping("region")
@RestController
public class RegionController {

    @Autowired
    RegionService regionService;

    @RequestMapping("list")
    public QueryVo getRegionList(){
        return regionService.getRegionList();
    }

}
