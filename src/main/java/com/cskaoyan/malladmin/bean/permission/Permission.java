package com.cskaoyan.malladmin.bean.permission;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

/**
 * @Author: Dankin
 * @Date: 2019/5/24 16:28
 */
public class Permission {
    private int id;
    private int role_id;
    private String permission;
    private Date add_time;
    private Date update_time;
    private int deleted;

    public Permission(int id, int role_id, String permission, Date add_time, Date update_time, int deleted) {
        this.id = id;
        this.role_id = role_id;
        this.permission = permission;
        this.add_time = add_time;
        this.update_time = update_time;
        this.deleted = deleted;
    }
}
