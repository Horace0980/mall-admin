package com.cskaoyan.malladmin.bean.wxCategory;

import com.cskaoyan.malladmin.bean.market.Category;

import java.util.Date;
import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:22
 */
public class WxCategory {
    public WxCategory() {
    }

    int id;
    String name;
    String keywords;
    String desc;
    int pid;
    String icon_url;
    String pic_url;
    String level;
    int sort_order;
    Date add_time;
    Date update_time;
    int deleted;

    @Override
    public String toString() {
        return "WxCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keywords='" + keywords + '\'' +
                ", desc='" + desc + '\'' +
                ", pid=" + pid +
                ", icon_url='" + icon_url + '\'' +
                ", pic_url='" + pic_url + '\'' +
                ", level='" + level + '\'' +
                ", sort_order=" + sort_order +
                ", add_time=" + add_time +
                ", update_time=" + update_time +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public WxCategory(int id, String name, String keywords, String desc, int pid, String icon_url, String pic_url, String level, int sort_order, Date add_time, Date update_time, int deleted) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.desc = desc;
        this.pid = pid;
        this.icon_url = icon_url;
        this.pic_url = pic_url;
        this.level = level;
        this.sort_order = sort_order;
        this.add_time = add_time;
        this.update_time = update_time;
        this.deleted = deleted;
    }
}
