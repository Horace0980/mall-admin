package com.cskaoyan.malladmin.bean.system;

import java.util.Date;

/**
 * @Author:ZCH
 * @Date:2019/5/22 20:21
 */
public class MallSystem {
    private int id;
    private String keyName;
    private String keyValue;
    private Date addTime;
    private Date updateTime;
    private int deleted;

    public MallSystem() {
    }

    public MallSystem(int id, String keyName, String keyValue, Date addTime, Date updateTime, int deleted) {
        this.id = id;
        this.keyName = keyName;
        this.keyValue = keyValue;
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

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "MallSystem{" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                ", keyValue='" + keyValue + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
