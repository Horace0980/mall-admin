package com.cskaoyan.malladmin.bean.role;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 0:16
 */
public class RoleData {
  private int limit;
  private List<Role> items;
  private int total;

  public RoleData() {
  }

  @Override
  public String toString() {
    return "RoleData{" +
      "limit=" + limit +
      ", items=" + items +
      ", total=" + total +
      '}';
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public List<Role> getItems() {
    return items;
  }

  public void setItems(List<Role> items) {
    this.items = items;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public RoleData(int limit, List<Role> items, int total) {
    this.limit = limit;
    this.items = items;
    this.total = total;
  }
}
