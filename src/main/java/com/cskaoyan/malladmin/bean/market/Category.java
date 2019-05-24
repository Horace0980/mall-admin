package com.cskaoyan.malladmin.bean.market;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 21:03
 */

public class Category {

    String desc;
    String iconUrl;
    int id;
    String keywords;
    String level;
    String name;
    String picUrl;
    List<Category> children;

    public Category() {
    }

    public Category(String desc, String iconUrl, int id, String keywords, String level, String name, String picUrl, List<Category> children) {
        this.desc = desc;
        this.iconUrl = iconUrl;
        this.id = id;
        this.keywords = keywords;
        this.level = level;
        this.name = name;
        this.picUrl = picUrl;
        this.children = children;
    }

    @Override
    public String toString() {
        return "Category{" +
                "desc='" + desc + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", id=" + id +
                ", keywords='" + keywords + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", children=" + children +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
