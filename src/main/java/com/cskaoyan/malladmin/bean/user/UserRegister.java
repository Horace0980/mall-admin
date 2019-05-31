package com.cskaoyan.malladmin.bean.user;

/**
 * @Author: Qiu
 * @Date: 2019/5/28 20:38
 */
public class UserRegister {
    String username;
    String password;
    String mobile;
    String code;
    String wxCode;

    public UserRegister(String username, String password, String mobile, String code, String wxCode) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.code = code;
        this.wxCode = wxCode;
    }

    public UserRegister() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    @Override
    public String toString() {
        return "UserRegister{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", code='" + code + '\'' +
                ", wxCode='" + wxCode + '\'' +
                '}';
    }
}
