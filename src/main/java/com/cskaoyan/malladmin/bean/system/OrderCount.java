package com.cskaoyan.malladmin.bean.system;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:52
 */
public class OrderCount {
    private int amount;
    private int customers;
    private String day;
    private int orders;
    private int pcr;

    public OrderCount() {
    }

    public OrderCount(int amount, int customers, String day, int orders, int pcr) {
        this.amount = amount;
        this.customers = customers;
        this.day = day;
        this.orders = orders;
        this.pcr = pcr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
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

    public int getPcr() {
        return pcr;
    }

    public void setPcr(int pcr) {
        this.pcr = pcr;
    }

    @Override
    public String toString() {
        return "OrderCount{" +
                "amount=" + amount +
                ", customers=" + customers +
                ", day='" + day + '\'' +
                ", orders=" + orders +
                ", pcr=" + pcr +
                '}';
    }
}
