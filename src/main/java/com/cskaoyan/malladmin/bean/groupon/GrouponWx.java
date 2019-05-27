package com.cskaoyan.malladmin.bean.groupon;

import com.cskaoyan.malladmin.bean.goods.Goods;

/**
 * @Author:ZCH
 * @Date:2019/5/27 20:16
 */
public class GrouponWx {
    private Goods goods;
    private int groupon_member;
    private double groupon_price;

    public GrouponWx() {
    }

    public GrouponWx(Goods goods, int groupon_member, double groupon_price) {
        this.goods = goods;
        this.groupon_member = groupon_member;
        this.groupon_price = groupon_price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }

    @Override
    public String toString() {
        return "GrouponWx{" +
                "goods=" + goods +
                ", groupon_member=" + groupon_member +
                ", groupon_price=" + groupon_price +
                '}';
    }
}
