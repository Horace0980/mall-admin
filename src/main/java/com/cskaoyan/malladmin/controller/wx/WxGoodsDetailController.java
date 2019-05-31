package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: yyc
 * @Date: 2019/5/31 19:08
 */
@RestController
@RequestMapping("wx/goods")
public class WxGoodsDetailController {

    @RequestMapping("detail")
    public QueryVo getDetailById(String id){

        return new QueryVo(0,null,"成功");
    }
}
