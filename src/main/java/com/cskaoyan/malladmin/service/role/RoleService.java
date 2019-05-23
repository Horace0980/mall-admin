package com.cskaoyan.malladmin.service.role;

import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Dankin
 * @Date: 2019/5/22 21:51
 */
public interface RoleService {
  public QueryVo queryRolePage(int page,int limit);
  QueryVo queryRoleOPtions();
}
