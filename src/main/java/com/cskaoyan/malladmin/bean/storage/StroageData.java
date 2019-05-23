package com.cskaoyan.malladmin.bean.storage;


import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:28
 */
public class StroageData {
  private List<Storage> items;
  private int total;

  @Override
  public String toString() {
    return "StroageData{" +
      "items=" + items +
      ", total=" + total +
      '}';
  }

  public List<Storage> getItems() {
    return items;
  }

  public void setItems(List<Storage> items) {
    this.items = items;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public StroageData() {
  }

  public StroageData(List<Storage> items, int total) {
    this.items = items;
    this.total = total;
  }
}
