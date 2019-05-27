package com.cskaoyan.malladmin.controller.WxCatalog;

import com.cskaoyan.malladmin.service.WxCatalog.WxCatalogService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:09
 */

@RestController
@RequestMapping("wx")
public class WxCatalogController {

    @Autowired
    WxCatalogService wxCatalogService;

    @RequestMapping("catalog/index")
    public QueryVo index(){
        QueryVo queryVo = wxCatalogService.queryIndex();
        return queryVo;
    }

    @RequestMapping("catalog/current")
    public QueryVo current(int id){
        QueryVo queryVo = wxCatalogService.current(id);
        return queryVo;
    }
}
