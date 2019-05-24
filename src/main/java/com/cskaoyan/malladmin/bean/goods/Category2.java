package com.cskaoyan.malladmin.bean.goods;

import java.util.List;

/**
 * @Author : zjf
 * @Date : 2019/5/24 下午 03:33
 */
public class Category2 {
    private int value;
    private String label;
    List<Children> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Category2{" +
                "value=" + value +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
