package com.cskaoyan.malladmin.bean.system;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:41
 */
public class UserCount {
    private String day;
    private int users;

    public UserCount() {
    }

    public UserCount(String day, int users) {
        this.day = day;
        this.users = users;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }


}
