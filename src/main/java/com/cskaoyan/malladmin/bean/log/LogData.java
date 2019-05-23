package com.cskaoyan.malladmin.bean.log;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:54
 */
public class LogData {
  private List<Log> items;
  private int total;

  public LogData() {
  }

  @Override
  public String toString() {
    return "LogData{" +
      "items=" + items +
      ", total=" + total +
      '}';
  }

  public List<Log> getItems() {
    return items;
  }

  public void setItems(List<Log> items) {
    this.items = items;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public LogData(List<Log> items, int total) {
    this.items = items;
    this.total = total;
  }
}
