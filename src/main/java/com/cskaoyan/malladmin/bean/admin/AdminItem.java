package com.cskaoyan.malladmin.bean.admin;


import java.awt.*;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 10:08
 */
public class AdminItem {
  private String avatar;
  private int id;
  private int[] roleIds;
  private String username;
  private String password;

  public AdminItem(String avatar, int id, int[] roleIds, String username, String password, Date updateTime, Date addTime, String lastLoginIp, Date lastLoginTime, Boolean deleted) {
    this.avatar = avatar;
    this.id = id;
    this.roleIds = roleIds;
    this.username = username;
    this.password = password;
    this.updateTime = updateTime;
    this.addTime = addTime;
    this.lastLoginIp = lastLoginIp;
    this.lastLoginTime = lastLoginTime;
    this.deleted = deleted;
  }

  private Date updateTime;
  private Date addTime;
  private String lastLoginIp;
  private Date lastLoginTime;
  private Boolean deleted;

  @Override
  public String toString() {
    return "AdminItem{" +
      "avatar='" + avatar + '\'' +
      ", id=" + id +
      ", roleIds=" + Arrays.toString(roleIds) +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", updateTime=" + updateTime +
      ", addTime=" + addTime +
      ", lastLoginIp='" + lastLoginIp + '\'' +
      ", lastLoginTime=" + lastLoginTime +
      ", deleted=" + deleted +
      '}';
  }

  public String getLastLoginIp() {
    return lastLoginIp;
  }

  public void setLastLoginIp(String lastLoginIp) {
    this.lastLoginIp = lastLoginIp;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int[] getRoleIds() {
    return roleIds;
  }

  public void setRoleIds(int[] roleIds) {
    this.roleIds = roleIds;
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

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getAddTime() {
    return addTime;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public AdminItem() {
  }

}
