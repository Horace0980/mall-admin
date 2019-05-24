package com.cskaoyan.malladmin.bean.goods;

/**
 * @Author : zjf
 * @Date : 2019/5/24 下午 03:39
 */
public class Children {
    private int value;
    private String label;

    @Override
    public String toString() {
        return "Children{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }

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
}
