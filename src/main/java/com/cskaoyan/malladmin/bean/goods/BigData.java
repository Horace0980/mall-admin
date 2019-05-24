package com.cskaoyan.malladmin.bean.goods;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : zjf
 * @Date : 2019/5/23 下午 11:30
 */
public class BigData {
    private Goods goods;
    private GoodsAttribute[] attributes;
    private GoodsProduct[] products;
    private GoodsSpecification[] specifications;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(GoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

    public GoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(GoodsProduct[] products) {
        this.products = products;
    }

    public GoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(GoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "BigData{" +
                "goods=" + goods +
                ", attributes=" + Arrays.toString(attributes) +
                ", products=" + Arrays.toString(products) +
                ", specifications=" + Arrays.toString(specifications) +
                '}';
    }
}
