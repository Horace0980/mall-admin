package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.service.wx.WxBrandService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/5/27 22:25
 */

@RestController
@RequestMapping("wx")
public class WxBrandController {

    @Autowired
    WxBrandService wxBrandService;

    @RequestMapping("brand/detail")
    public QueryVo detail(String id){
        HashMap<Object, Object> map = new HashMap<>();
        Brand brand = wxBrandService.selectBrandById(id);
        map.put("brand",brand);
        return new QueryVo(0,map,"成功");
    }
}
