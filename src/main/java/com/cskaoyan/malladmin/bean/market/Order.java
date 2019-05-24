package com.cskaoyan.malladmin.bean.market;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 21:10
 */

public class Order {
    BigDecimal actualPrice;
    Date addTime;
    String address;
    Integer comments;
    String consignee;
    BigDecimal couponPrice;
    boolean deleted;
    Date endTime;
    BigDecimal freightPrice;
    BigDecimal goodsPrice;
    BigDecimal grouponPrice;
    int id;
    BigDecimal integralPrice;
    String message;
    String mobile;
    BigDecimal orderPrice;
    String orderSn;
    Integer orderStatus;
    Date updateTime;
    int userId;
    String payId;
    Date payTime;
    String shipSn;
    String shipChannel;
    Date shipTime;
    Date confirmTime;

  public Order() {
  }

  @Override
  public String toString() {
    return "Order{" +
      "actualPrice=" + actualPrice +
      ", addTime=" + addTime +
      ", address='" + address + '\'' +
      ", comments=" + comments +
      ", consignee='" + consignee + '\'' +
      ", couponPrice=" + couponPrice +
      ", deleted=" + deleted +
      ", endTime=" + endTime +
      ", freightPrice=" + freightPrice +
      ", goodsPrice=" + goodsPrice +
      ", grouponPrice=" + grouponPrice +
      ", id=" + id +
      ", integralPrice=" + integralPrice +
      ", message='" + message + '\'' +
      ", mobile='" + mobile + '\'' +
      ", orderPrice=" + orderPrice +
      ", orderSn='" + orderSn + '\'' +
      ", orderStatus=" + orderStatus +
      ", updateTime=" + updateTime +
      ", userId=" + userId +
      ", payId='" + payId + '\'' +
      ", payTime=" + payTime +
      ", shipSn='" + shipSn + '\'' +
      ", shipChannel='" + shipChannel + '\'' +
      ", shipTime=" + shipTime +
      ", confirmTime=" + confirmTime +
      '}';
  }

  public Order(BigDecimal actualPrice, Date addTime, String address, Integer comments, String consignee, BigDecimal couponPrice, boolean deleted, Date endTime, BigDecimal freightPrice, BigDecimal goodsPrice, BigDecimal grouponPrice, int id, BigDecimal integralPrice, String message, String mobile, BigDecimal orderPrice, String orderSn, Integer orderStatus, Date updateTime, int userId, String payId, Date payTime, String shipSn, String shipChannel, Date shipTime, Date confirmTime) {
    this.actualPrice = actualPrice;
    this.addTime = addTime;
    this.address = address;
    this.comments = comments;
    this.consignee = consignee;
    this.couponPrice = couponPrice;
    this.deleted = deleted;
    this.endTime = endTime;
    this.freightPrice = freightPrice;
    this.goodsPrice = goodsPrice;
    this.grouponPrice = grouponPrice;
    this.id = id;
    this.integralPrice = integralPrice;
    this.message = message;
    this.mobile = mobile;
    this.orderPrice = orderPrice;
    this.orderSn = orderSn;
    this.orderStatus = orderStatus;
    this.updateTime = updateTime;
    this.userId = userId;
    this.payId = payId;
    this.payTime = payTime;
    this.shipSn = shipSn;
    this.shipChannel = shipChannel;
    this.shipTime = shipTime;
    this.confirmTime = confirmTime;
  }

  public String getPayId() {
    return payId;
  }

  public void setPayId(String payId) {
    this.payId = payId;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public String getShipSn() {
    return shipSn;
  }

  public void setShipSn(String shipSn) {
    this.shipSn = shipSn;
  }

  public String getShipChannel() {
    return shipChannel;
  }

  public void setShipChannel(String shipChannel) {
    this.shipChannel = shipChannel;
  }

  public Date getShipTime() {
    return shipTime;
  }

  public void setShipTime(Date shipTime) {
    this.shipTime = shipTime;
  }

  public Date getConfirmTime() {
    return confirmTime;
  }

  public void setConfirmTime(Date confirmTime) {
    this.confirmTime = confirmTime;
  }

  public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(BigDecimal freightPrice) {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(BigDecimal grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getIntegralPrice() {
        return integralPrice;
    }

    public void setIntegralPrice(BigDecimal integralPrice) {
        this.integralPrice = integralPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
