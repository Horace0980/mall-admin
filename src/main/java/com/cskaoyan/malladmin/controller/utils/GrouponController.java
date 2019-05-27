package com.cskaoyan.malladmin.controller.utils;

import com.cskaoyan.malladmin.bean.groupon.GrouponRules;
import com.cskaoyan.malladmin.service.groupon.GrouponService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc
 * @Date: 2019/5/23 17:28
 */
@RestController
@RequestMapping("admin/groupon")
public class GrouponController {

    @Autowired
    private GrouponService grouponService;

    @RequestMapping("list")
    public QueryVo getinCondition(QueryIn queryIn,String goodsId){
        return grouponService.getInCondition(queryIn,goodsId);
    }
    @RequestMapping("create")
    public QueryVo addNew(@RequestBody GrouponRules grouponRules){
        return grouponService.addNew(grouponRules);

    }
    @RequestMapping("update")
    public QueryVo update(@RequestBody GrouponRules grouponRules){
        return grouponService.update(grouponRules);

    }
    @RequestMapping("delete")
    public QueryVo delete(@RequestBody GrouponRules grouponRules){
        return grouponService.delete(grouponRules);

    }
    @RequestMapping("listRecord")
    public QueryVo getGrouponRecord(QueryIn queryIn,String goodsId){
        return grouponService.getGrouponInCondition(queryIn,goodsId);
    }
}
