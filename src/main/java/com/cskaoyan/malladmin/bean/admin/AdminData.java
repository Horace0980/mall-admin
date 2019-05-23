package com.cskaoyan.malladmin.bean.admin;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/22 21:26
 */
public class AdminData {
  private int total;
  private List<AdminItem> items;


  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<AdminItem> getItems() {
    return items;
  }

  public void setItems(List<AdminItem> items) {
    this.items = items;
  }

  public AdminData() {
  }
}
