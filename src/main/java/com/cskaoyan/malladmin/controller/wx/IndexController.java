package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.service.goods.GoodsService;
import com.cskaoyan.malladmin.service.wx.IndexService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 15:30
 */
@RestController
@RequestMapping("wx")
public class IndexController {
    @Autowired
    GoodsService goodsService;

    @Autowired
    IndexService indexService;

    @RequestMapping("goods/count")
    public QueryVo indexCount() {
        QueryVo indexCount = goodsService.indexCount();
        return indexCount;
    }

    @RequestMapping("home/index")
    public QueryVo wxHome() {

        QueryVo wxHome = indexService.wxHome();
        return wxHome;
    }

}
