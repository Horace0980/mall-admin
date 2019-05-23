package com.cskaoyan.malladmin.bean.role;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 9:40
 */
public class RoleOption {
  private int value;
  private String label;

  public RoleOption() {
  }

  @Override
  public String toString() {
    return "RoleOption{" +
      "value=" + value +
      ", label='" + label + '\'' +
      '}';
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public RoleOption(int value, String label) {
    this.value = value;
    this.label = label;
  }
}
