package com.cskaoyan.malladmin.service.goods.Impl;

import com.cskaoyan.malladmin.bean.goods.*;
import com.cskaoyan.malladmin.mapper.goods.GoodsAttributeMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsProductMapper;
import com.cskaoyan.malladmin.mapper.goods.GoodsSpecificationMapper;
import com.cskaoyan.malladmin.service.goods.GoodsService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Attribute;
import java.util.HashMap;
import java.util.List;

/**
 * @Author : zjf
 * @Date : 2019/5/22 下午 11:14
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;

    @Override
    public QueryVo allList(QueryIn queryIn, Integer id, String name) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if(id != null){
            criteria.andIdEqualTo(id);
        }else if(name != null){
            criteria.andNameLike("%" + name + "%");
        }else{
            criteria.getAllCriteria();
        }
        PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        PageInfo pageInfo = new PageInfo(goods);
        HashMap<String,Object> map = new HashMap<>();
        map.put("items",goods);
        map.put("total",pageInfo.getTotal());
        return new QueryVo(0,map,"成功");
    }

    @Override
    public QueryVo deleteById(Goods goods) {
        int i = goodsMapper.deleteByPrimaryKey(goods.getId());
        return new QueryVo(0,"","成功");
    }

    @Override
    public QueryVo detailById(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);

        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria criteria = goodsAttributeExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        List<GoodsAttribute> goodsAttributes = goodsAttributeMapper.selectByExample(goodsAttributeExample);

        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria criteria1 = goodsProductExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        List<GoodsProduct> goodsProducts = goodsProductMapper.selectByExample(goodsProductExample);

        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        GoodsSpecificationExample.Criteria criteria2 = goodsSpecificationExample.createCriteria();
        criteria2.andGoodsIdEqualTo(id);
        List<GoodsSpecification> goodsSpecifications = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);

        HashMap<String,Object> map = new HashMap<>();
        map.put("goods",goods);
        map.put("attributes",goodsAttributes.get(0));
        map.put("products",goodsProducts.get(0));
        map.put("specifications",goodsSpecifications.get(0));
        return new QueryVo(0,map,"成功");
    }

    @Override
    public String getNameById(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods.getName();
    }

    @Override
    public QueryVo catAndBrand() {
        return null;
    }


}
