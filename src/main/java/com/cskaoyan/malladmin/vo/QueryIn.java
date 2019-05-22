package com.cskaoyan.malladmin.vo;

/**
 * @Author: yyc
 * @Date: 2019/5/22 19:54
 */
public class QueryIn {
    private int page;
    private int limit;
    private String sort;
    private String order;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
