package com.cskaoyan.malladmin.vo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:04
 */
public class PageHandler<T> {
    private int total;
    private List<T> items;

    public PageHandler() {
    }

    public PageHandler(int total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
