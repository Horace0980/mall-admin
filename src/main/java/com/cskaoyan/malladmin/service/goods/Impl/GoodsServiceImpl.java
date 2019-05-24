package com.cskaoyan.malladmin.service.goods.Impl;

import com.cskaoyan.malladmin.bean.goods.*;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.goods.*;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.service.goods.GoodsService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public QueryVo allList(QueryIn queryIn, Integer goodsSn, String name) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if(goodsSn != null){
            criteria.andIdEqualTo(goodsSn);
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

        Category category = categoryMapper.selectById(goods.getCategoryId());

        Integer[] categoryIds = new Integer[2];
        categoryIds[0] = category.getPid();
        categoryIds[1] = category.getId();

        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria criteria = goodsAttributeExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        List<GoodsAttribute> goodsAttribute = goodsAttributeMapper.selectByExample(goodsAttributeExample);
        GoodsAttribute[] goodsAttributes = new GoodsAttribute[goodsAttribute.size()];
        for (int i = 0; i < goodsAttribute.size(); i++) {
            goodsAttributes[i] = goodsAttribute.get(i);
        }

        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria criteria1 = goodsProductExample.createCriteria();
        criteria1.andGoodsIdEqualTo(id);
        List<GoodsProduct> goodsProduct = goodsProductMapper.selectByExample(goodsProductExample);
        GoodsProduct[] goodsProducts = new GoodsProduct[goodsProduct.size()];
        for (int i = 0; i < goodsProduct.size(); i++) {
            goodsProducts[i] = goodsProduct.get(i);
        }


        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        GoodsSpecificationExample.Criteria criteria2 = goodsSpecificationExample.createCriteria();
        criteria2.andGoodsIdEqualTo(id);
        List<GoodsSpecification> goodsSpecification = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
        GoodsSpecification[] goodsSpecifications = new GoodsSpecification[goodsSpecification.size()];
        for (int i = 0; i < goodsSpecification.size(); i++) {
            goodsSpecifications[i] = goodsSpecification.get(i);
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("goods",goods);
        map.put("attributes",goodsAttributes);
        map.put("products",goodsProducts);
        map.put("specifications",goodsSpecifications);
        map.put("categoryIds",categoryIds);
        return new QueryVo(0,map,"成功");
    }

    @Override
    public String getNameById(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods.getName();
    }

    @Override
    public QueryVo catAndBrand() {
        List<Brand> brands = brandMapper.queryBrandList(null, null);
        List<Brand2> brandList = new ArrayList<>();
        for (Brand brand : brands) {
            Brand2 brand2 = new Brand2();
            brand2.setValue(brand.getId());
            brand2.setLabel(brand.getName());
            brandList.add(brand2);
        }

        List<Category2> categoryList = new ArrayList<>();


        List<Category> l1 = categoryMapper.getList(0);
        for (Category c : l1){
            Category2 category = new Category2();
            category.setValue(c.getId());
            category.setLabel(c.getName());

            List<Children> children = new ArrayList<>();
            int id = c.getId();
            List<Category> list = categoryMapper.getList(id);
            for (Category c2 : list) {
                Children  children1 = new Children();
                children1.setValue(c2.getId());
                children1.setLabel(c2.getName());
                children.add(children1);
            }
            category.setChildren(children);
            categoryList.add(category);
        }


        HashMap<String,Object> map = new HashMap<>();
        map.put("brandList",brandList);
        map.put("categoryList",categoryList);
        return new QueryVo(0,map,"成功");
    }

    @Override
    public QueryVo inserts(BigData bigData) {
        goodsMapper.insert(bigData.getGoods());
        Integer id = bigData.getGoods().getId();

        GoodsAttribute[] attributes = bigData.getAttributes();
        for (GoodsAttribute attribute : attributes) {
            attribute.setGoodsId(id);
            int insert = goodsAttributeMapper.insert(attribute);
        }

        GoodsProduct[] products = bigData.getProducts();
        for (GoodsProduct product : products) {
            product.setGoodsId(id);
            int insert = goodsProductMapper.insert(product);
        }

        GoodsSpecification[] specifications = bigData.getSpecifications();
        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(id);
            int insert = goodsSpecificationMapper.insert(specification);
        }

        return new QueryVo(0,"","成功");
    }

    @Override
    public QueryVo updates(UpdateData updateData) {
        int update = goodsMapper.updateByPrimaryKey(updateData.getGoods());

        int update1 = goodsAttributeMapper.updateByPrimaryKey(updateData.getAttributes());

        int update2 = goodsProductMapper.updateByPrimaryKey(updateData.getProducts());

        int update3 = goodsSpecificationMapper.updateByPrimaryKey(updateData.getSpecifications());

        return new QueryVo(0,"","成功");
    }
}
