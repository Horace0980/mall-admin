package com.cskaoyan.malladmin.vo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:04
 */
public class PageHandler<T> {
    private int total;
    private int pages;
    private int limit;
    private int page;
    private List<T> list;

    public PageHandler() {
    }

    public PageHandler(int total, int pages, int limit, int page, List<T> list) {
        this.total = total;
        this.pages = pages;
        this.limit = limit;
        this.page = page;
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "total=" + total +
                ", pages=" + pages +
                ", limit=" + limit +
                ", page=" + page +
                ", list=" + list +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getpage() {
        return page;
    }

    public void setpage(int page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
