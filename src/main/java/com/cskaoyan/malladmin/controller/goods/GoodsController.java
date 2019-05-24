package com.cskaoyan.malladmin.controller.goods;

import com.cskaoyan.malladmin.bean.goods.*;
import com.cskaoyan.malladmin.service.goods.GoodsService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : zjf
 * @Date : 2019/5/22 下午 11:12
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/list")
    @ResponseBody
    public QueryVo goodslist(QueryIn queryIn,Integer goodsSn,String name){
        return goodsService.allList(queryIn,goodsSn,name);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public QueryVo goodslist(@RequestBody Goods goods){
        return goodsService.deleteById(goods);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public QueryVo goodsdetail(Integer id){
        return goodsService.detailById(id);
    }

    @RequestMapping("/catAndBrand")
    @ResponseBody
    public QueryVo catAndBrand(){
        return goodsService.catAndBrand();
    }

    @RequestMapping("/create")
    @ResponseBody
    public QueryVo insert(@RequestBody BigData bigData){
        return goodsService.inserts(bigData);
    }

    @RequestMapping("/update")
    @ResponseBody
    public QueryVo updates(@RequestBody UpdateData updateData){
        return goodsService.updates(updateData);
    }
}
