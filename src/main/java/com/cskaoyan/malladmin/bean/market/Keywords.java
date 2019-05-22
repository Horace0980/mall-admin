package com.cskaoyan.malladmin.bean.market;

import java.util.Date;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 21:30
 */
public class Keywords {
    int id;
    String keyword;
    String url;
    boolean isHot;
    boolean isDefault;
    int sortOrder;
    Date addTime;
    Date updateTime;
    boolean deleted;

    public Keywords() {
    }

    public Keywords(int id, String keyword, String url, boolean isHot, boolean isDefault, int sortOrder, Date addTime, Date updateTime, boolean deleted) {
        this.id = id;
        this.keyword = keyword;
        this.url = url;
        this.isHot = isHot;
        this.isDefault = isDefault;
        this.sortOrder = sortOrder;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Keywords{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                ", isHot=" + isHot +
                ", isDefault=" + isDefault +
                ", sortOrder=" + sortOrder +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
