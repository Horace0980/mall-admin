package com.cskaoyan.malladmin.bean.market;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 20:44
 */

public class Brand {
    int id;
    String name;
    String desc;
    String picUrl;
    int sortOrder;
    BigDecimal floorPrice;
    Date addTime;
    Date updateTime;
    boolean deleted;

    public Brand() {
    }

    public Brand(int id, String name, String desc, String picUrl, int sortOrder, BigDecimal floorPrice, Date addTime, Date updateTime, boolean deleted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.picUrl = picUrl;
        this.sortOrder = sortOrder;
        this.floorPrice = floorPrice;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }


    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", sortOrder=" + sortOrder +
                ", floorPrice=" + floorPrice +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
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

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
