package com.cskaoyan.malladmin.service.groupon.impl;

import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.groupon.Groupon;
import com.cskaoyan.malladmin.bean.groupon.GrouponExample;
import com.cskaoyan.malladmin.bean.groupon.GrouponRules;
import com.cskaoyan.malladmin.bean.groupon.GrouponRulesExample;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.groupon.GrouponMapper;
import com.cskaoyan.malladmin.mapper.groupon.GrouponRulesMapper;
import com.cskaoyan.malladmin.service.groupon.GrouponService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/23 17:32
 */
@Service
public class GrouponServiceImpl implements GrouponService {
    @Autowired
    private GrouponMapper grouponMapper;
    @Autowired
    private GrouponRulesMapper grouponRulesMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public QueryVo getInCondition(QueryIn queryIn, String goodsId) {
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.setOrderByClause(queryIn.getSort()+" "+queryIn.getOrder());
        GrouponRulesExample.Criteria or = grouponRulesExample.or();
        if (goodsId!=null && goodsId.trim().length()>0){
            try {
                or.andGoodsIdEqualTo(Integer.parseInt(goodsId));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return new QueryVo(605,null,"商品id应该是整数！");
            }
        }
        long l = grouponRulesMapper.countByExample(grouponRulesExample);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);

        HashMap<String, Object> map = new HashMap<>();
        map.put("items",grouponRules);
        map.put("total",l);
        return new QueryVo(0,map,"成功");
    }

    @Override
    public QueryVo addNew(GrouponRules grouponRules) {
        //先查商品id 得到商品名 todo
        Goods goods = goodsMapper.selectByPrimaryKey(grouponRules.getGoodsId());
        if (goods==null){
            return new QueryVo(402,null,"商品id参数不对");
        }
        grouponRules.setGoodsName(goods.getName());
        grouponRules.setPicUrl(goods.getPicUrl());
        Date addTime = new Date();
        grouponRules.setAddTime(addTime);
        grouponRules.setUpdateTime(addTime);
        grouponRules.setDeleted(false);
        grouponRulesMapper.insertSelective(grouponRules);
        return new QueryVo(0,grouponRules,"成功");
    }

    @Override
    public QueryVo update(GrouponRules grouponRules) {
        grouponRules.setUpdateTime(new Date());
        int res = grouponRulesMapper.updateByPrimaryKeySelective(grouponRules);
        if (res!=1){
            return new QueryVo(605,null,"网络异常");

        }
        return new QueryVo(0,grouponRules,"成功");
    }

    @Override
    public QueryVo delete(GrouponRules grouponRules) {
        grouponRules.setUpdateTime(new Date());
        grouponRules.setDeleted(true);
        int res = grouponRulesMapper.updateByPrimaryKeySelective(grouponRules);
        if (res!=1){
            return new QueryVo(605,null,"网络异常");

        }
        return new QueryVo(0,null,"成功");
    }

    @Override
    public QueryVo getGrouponInCondition(QueryIn queryIn, String goodsId) {
        GrouponExample grouponExample = new GrouponExample();
        grouponExample.setOrderByClause(queryIn.getSort()+" "+queryIn.getOrder());
        GrouponExample.Criteria or = grouponExample.or();
        if (goodsId!=null && goodsId.trim().length()>0){
//            try {
                or.andGrouponIdEqualTo(Integer.parseInt(goodsId.trim()));
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new QueryVo(402,null,"参数异常");
//            }
        }
        long l = grouponMapper.countByExample(grouponExample);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",groupons);
        map.put("total",l);
        return new QueryVo(0,map,"成功");
    }
}
