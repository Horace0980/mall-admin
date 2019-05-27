package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.bean.goods.Goods;
import com.cskaoyan.malladmin.bean.goods.GoodsExample;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.goods.GoodsMapper;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.service.wx.WxxCategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2019/5/27 16:26
 */
@Service
public class WxxCategoryServiceImpl implements WxxCategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public QueryVo getById(String id) {
        HashMap<String,Object> map = new HashMap<>();
        Category current = categoryMapper.selectById(Integer.parseInt(id));
        if (current.getPid()==0){
            //是一级目录
            List<Category> categories = categoryMapper.getList(Integer.parseInt(id));
            map.put("brotherCategory",categories);
            map.put("currentCategory",categories.get(0));
            map.put("parentCategory",current);
            return new QueryVo(0,map,"成功");
        }
        //是二级目录
        Category parent = categoryMapper.selectById(current.getPid());
        List<Category> categories = categoryMapper.getList(current.getPid());
        map.put("brotherCategory",categories);
        map.put("currentCategory",current);
        map.put("parentCategory",parent);
        return new QueryVo(0,map,"成功");
    }

    /**
     * 点击商品类别返回的商品list
     * @param categoryId
     * @param page
     * @param size
     * @return
     */
    @Override
    public QueryVo getGoodsListInPage(String categoryId, String page, String size) {
        HashMap<String,Object> map = new HashMap<>();
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.or().andCategoryIdEqualTo(Integer.parseInt(categoryId));
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        map.put("filterCategoryList",null);
        map.put("goodsList",goods);
        map.put("count",goods.size());
        return new QueryVo(0,map,"成功");
    }

    /**
     * 根据关键字返回的搜索商品list,可能来自多个品牌，品牌放在filterCategory返回了
     * @param keyword
     * @param sort
     * @param order
     * @param page
     * @param size
     * @return
     */
    @Override
    public QueryVo getGoodsListInPageByKeyword(String keyword, String sort, String order, String page, String size) {
        HashMap<String,Object> map = new HashMap<>();
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort+" "+order);
        goodsExample.or().andNameLike("%"+keyword+"%");
        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);

        Set<Integer> category_ids = new HashSet<>();
        for (Goods good : goods) {
            category_ids.add(good.getCategoryId());
        }
        List<Category> categories = categoryMapper.selectByIdIn(category_ids);
        map.put("filterCategoryList",categories);
        map.put("goodsList",goods);
        map.put("count",goods.size());
        //todo 搜索之后添加session历史搜索，热门搜索
        return new QueryVo(0,map,"成功");
    }
}
