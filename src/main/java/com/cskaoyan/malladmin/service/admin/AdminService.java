package com.cskaoyan.malladmin.service.admin;

import com.cskaoyan.malladmin.bean.admin.Admin;
import com.cskaoyan.malladmin.vo.QueryVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yyc
 * @Date: 2019/5/22 15:00
 */
public interface AdminService {
    QueryVo login(Admin admin, HttpServletRequest request);

    QueryVo getInfo(Admin adminInfo);
}
