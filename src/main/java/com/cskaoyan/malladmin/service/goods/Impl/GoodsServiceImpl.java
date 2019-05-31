package com.cskaoyan.malladmin.service.goods.Impl;

import com.cskaoyan.malladmin.bean.goods.*;
import com.cskaoyan.malladmin.bean.groupon.GrouponRules;
import com.cskaoyan.malladmin.bean.groupon.GrouponRulesExample;
import com.cskaoyan.malladmin.bean.market.Brand;
import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.bean.market.Issue;
import com.cskaoyan.malladmin.mapper.goods.*;
import com.cskaoyan.malladmin.mapper.groupon.GrouponMapper;
import com.cskaoyan.malladmin.mapper.groupon.GrouponRulesMapper;
import com.cskaoyan.malladmin.mapper.market.BrandMapper;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.mapper.market.IssueMapper;
import com.cskaoyan.malladmin.service.goods.GoodsService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
  @Autowired
  CommentMapper commentMapper;
  @Autowired
  GrouponMapper grouponMapper;
  @Autowired
  GrouponRulesMapper grouponRulesMapper;

  @Override
  public QueryVo allList(QueryIn queryIn, Integer goodsSn, String name) {
    GoodsExample goodsExample = new GoodsExample();
    GoodsExample.Criteria criteria = goodsExample.createCriteria();
    if (goodsSn != null) {
      criteria.andIdEqualTo(goodsSn);
    } else if (name != null) {
      criteria.andNameLike("%" + name + "%");
    } else {
      criteria.getAllCriteria();
    }
    PageHelper.startPage(queryIn.getPage(), queryIn.getLimit());
    List<Goods> goods = goodsMapper.selectByExample(goodsExample);
    PageInfo pageInfo = new PageInfo(goods);
    HashMap<String, Object> map = new HashMap<>();
    map.put("items", goods);
    map.put("total", pageInfo.getTotal());
    return new QueryVo(0, map, "成功");
  }

  @Override
  public QueryVo deleteById(Goods goods) {
    int i = goodsMapper.deleteByPrimaryKey(goods.getId());
    return new QueryVo(0, "", "成功");
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

    HashMap<String, Object> map = new HashMap<>();
    map.put("goods", goods);
    map.put("attributes", goodsAttributes);
    map.put("products", goodsProducts);
    map.put("specifications", goodsSpecifications);
    map.put("categoryIds", categoryIds);
    return new QueryVo(0, map, "成功");
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
    for (Category c : l1) {
      Category2 category = new Category2();
      category.setValue(c.getId());
      category.setLabel(c.getName());

      List<Children> children = new ArrayList<>();
      int id = c.getId();
      List<Category> list = categoryMapper.getList(id);
      for (Category c2 : list) {
        Children children1 = new Children();
        children1.setValue(c2.getId());
        children1.setLabel(c2.getName());
        children.add(children1);
      }
      category.setChildren(children);
      categoryList.add(category);
    }


    HashMap<String, Object> map = new HashMap<>();
    map.put("brandList", brandList);
    map.put("categoryList", categoryList);
    return new QueryVo(0, map, "成功");
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

    return new QueryVo(0, "", "成功");
  }

  @Override
  public QueryVo updates(UpdateData updateData) {
    int update = goodsMapper.updateByPrimaryKey(updateData.getGoods());

    int update1 = goodsAttributeMapper.updateByPrimaryKey(updateData.getAttributes());

    int update2 = goodsProductMapper.updateByPrimaryKey(updateData.getProducts());

    int update3 = goodsSpecificationMapper.updateByPrimaryKey(updateData.getSpecifications());

    return new QueryVo(0, "", "成功");
  }

  @Override
  public QueryVo indexCount() {
      HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

      int goodsTotal = goodsMapper.getGoodsTotal();

      objectObjectHashMap.put("goodsCount",goodsTotal);

      return new QueryVo(0,objectObjectHashMap,"success");

  }
@Autowired
  IssueMapper issueMapper;

  @Override
  public QueryVo getWxDetail(int id) {
    HashMap<String,Object> data = new HashMap<>();
    Goods goods = goodsMapper.selectByPrimaryKey(id);
    GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
    goodsAttributeExample.or().andGoodsIdEqualTo(id);
    List<GoodsAttribute> goodsAttributes = goodsAttributeMapper.selectByExample(goodsAttributeExample);
    data.put("attribute",goodsAttributes);
    Integer brandId = goods.getBrandId();
    if (brandId==0){
      data.put("brand", null);
    }else {
      Brand brand = brandMapper.selectBrandById(brandId);
      data.put("brand", brand);
    }
    CommentExample commentExample = new CommentExample();
    commentExample.or().andValueIdEqualTo(id);
    List<Comment> comments = commentMapper.selectByExample(commentExample);
    if (comments.size()>0){
      HashMap<String,Object> comment = new HashMap<>();
      comment.put("count",comments.size());
      comment.put("data",comments);
      data.put("comment",comment);
    }else{
      HashMap<String,Object> comment = new HashMap<>();
      comment.put("count",0);
      comment.put("data",comments);
      data.put("comment",comment);
    }

    GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
    grouponRulesExample.or().andGoodsIdEqualTo(id);
    List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);

    data.put("groupon",grouponRules);

    data.put("info",goods);

    List<Issue> issues = issueMapper.queryIssueList(null);

    data.put("issue",issues);
    GoodsProductExample goodsProductExample = new GoodsProductExample();
    goodsAttributeExample.or().andGoodsIdEqualTo(id);
    List<GoodsProduct> goodsProducts = goodsProductMapper.selectByExample(goodsProductExample);

    data.put("productList",goodsProducts);
    //todo
    GoodsSpecificationExample specificationExample  = new GoodsSpecificationExample();
    goodsAttributeExample.or().andGoodsIdEqualTo(id);
    List<GoodsSpecification> goodsSpecifications = goodsSpecificationMapper.selectByExample(specificationExample);
    Set<String> set = new HashSet<>();
    for (GoodsSpecification goodsSpecification : goodsSpecifications) {
      set.add(goodsSpecification.getSpecification()) ;
    }
    ArrayList<Object> splist = new ArrayList<>();
    for (String p : set) {
      HashMap<String, Object> map = new HashMap<>();
      map.put("name",p);
      map.put("valueList",getSpecByidAndSpec(id,p));
      splist.add(map);
    }
    data.put("specificationList",splist);
    //收藏家
    data.put("userHasCollect",0);

    return new QueryVo(0,data,"成功");



  }

  private List<GoodsSpecification> getSpecByidAndSpec(int id, String p) {
    GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
    goodsSpecificationExample.or().andGoodsIdEqualTo(id).andSpecificationEqualTo(p);
    return  goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
  }
}
