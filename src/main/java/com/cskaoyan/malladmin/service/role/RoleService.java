package com.cskaoyan.malladmin.service.role;

import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Dankin
 * @Date: 2019/5/22 21:51
 */
public interface RoleService {

  QueryVo queryRolePage(int page,int limit);

  QueryVo queryRoleOPtions();

  QueryVo queryRolePageByName(int page,int limit,String name);

  QueryVo insertRole(Role role);

  QueryVo updateRole(Role role);

  QueryVo deleteRole(Integer id);
}
