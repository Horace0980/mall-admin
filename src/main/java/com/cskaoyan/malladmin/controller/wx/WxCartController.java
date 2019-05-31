package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc
 * @Date: 2019/5/31 19:11
 */
@RestController
@RequestMapping("wx/cart")
public class WxCartController {

    @RequestMapping("goodscount")
    public QueryVo getGoodscount(){
        return new QueryVo(0,null,"成功");
    }
}
