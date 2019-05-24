package com.cskaoyan.malladmin.service.admin;

import com.cskaoyan.malladmin.bean.admin.Admin;
import com.cskaoyan.malladmin.bean.admin.AdminItem;
import com.cskaoyan.malladmin.vo.QueryVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yyc
 * @Date: 2019/5/22 15:00
 */
public interface AdminService {
    QueryVo login(Admin admin, HttpServletRequest request);

    QueryVo getInfo(Admin adminInfo);

    QueryVo queryAdminPage(int page,int limit);

    boolean addAdmin(AdminItem admin);

    boolean QueryAdminName(String name);

    QueryVo queryAdminPageByName(int page,int limit,String name);

    QueryVo updateAdmin(AdminItem adminItem);

    QueryVo deleteAdmin(AdminItem adminItem);

}
