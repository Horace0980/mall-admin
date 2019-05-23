package com.cskaoyan.malladmin.bean.admin;


import java.awt.*;
import java.util.Arrays;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 10:08
 */
public class AdminItem {
  private String avatar;
  private int id;
  private int[] roleIds;
  private String username;

  public AdminItem() {

  }

  public AdminItem(String avatar, int id, int[] roleIds, String username) {
    this.avatar = avatar;
    this.id = id;
    this.roleIds = roleIds;
    this.username = username;
  }

  @Override
  public String toString() {
    return "AdminItem{" +
      "avatar='" + avatar + '\'' +
      ", id=" + id +
      ", roleIds=" + Arrays.toString(roleIds) +
      ", username='" + username + '\'' +
      '}';
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
}
