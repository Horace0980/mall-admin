package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.service.goods.GoodsService;
import com.cskaoyan.malladmin.service.wx.IndexService;
import com.cskaoyan.malladmin.service.wx.impl.IndexServiceImpl;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/31 19:08
 */
@RestController
@RequestMapping("wx/goods")
public class WxGoodsDetailController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    IndexServiceImpl indexService;
    @RequestMapping("detail")
    public QueryVo getDetailById(String id){

        return goodsService.getWxDetail(Integer.parseInt(id));
    }

    @RequestMapping("related")
    public QueryVo getRelated(String id){
        List<Goods> hotGoodsList = indexService.getRelatedGoodsList(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsList",hotGoodsList);
        return new QueryVo(0,map,"成功");
    }
}
