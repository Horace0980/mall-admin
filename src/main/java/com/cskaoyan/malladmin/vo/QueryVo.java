package com.cskaoyan.malladmin.vo;

/**
 * @Author: yyc
 * @Date: 2019/5/22 15:06
 */
public class QueryVo {
    private int errno;
    private Object data;
    private String errmsg;

    public QueryVo() {
    }

    public QueryVo(int errno, Object data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
