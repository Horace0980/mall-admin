package com.cskaoyan.malladmin.bean;

import java.util.Date;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 20:49
 */
public class Image {
    int id;
    String key;
    String name;
    int size;
    String type;
    Date addTime;
    Date updateTime;
    String url;

    public Image() {
    }

    public Image(int id, String key, String name, int size, String type, Date addTime, Date updateTime, String url) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.size = size;
        this.type = type;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", url='" + url + '\'' +
                '}';
    }
}
