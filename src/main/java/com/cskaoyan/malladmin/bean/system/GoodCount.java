package com.cskaoyan.malladmin.bean.system;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:54
 */
public class GoodCount {
    private int amount;
    private String day;
    private int orders;
    private int products;

    public GoodCount() {
    }

    public GoodCount(int amount, String day, int orders, int products) {
        this.amount = amount;
        this.day = day;
        this.orders = orders;
        this.products = products;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "GoodCount{" +
                "amount=" + amount +
                ", day='" + day + '\'' +
                ", orders=" + orders +
                ", products=" + products +
                '}';
    }
}
