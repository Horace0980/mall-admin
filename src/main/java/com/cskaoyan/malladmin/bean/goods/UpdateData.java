package com.cskaoyan.malladmin.bean.goods;

/**
 * @Author : zjf
 * @Date : 2019/5/24 上午 10:42
 */
public class UpdateData {
    private Goods goods;
    private GoodsAttribute attributes;
    private GoodsProduct products;
    private GoodsSpecification specifications;

    @Override
    public String toString() {
        return "updateData{" +
                "goods=" + goods +
                ", attributes=" + attributes +
                ", products=" + products +
                ", specifications=" + specifications +
                '}';
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(GoodsAttribute attributes) {
        this.attributes = attributes;
    }

    public GoodsProduct getProducts() {
        return products;
    }

    public void setProducts(GoodsProduct products) {
        this.products = products;
    }

    public GoodsSpecification getSpecifications() {
        return specifications;
    }

    public void setSpecifications(GoodsSpecification specifications) {
        this.specifications = specifications;
    }
}
