package com.cskaoyan.malladmin.service.role.impl;

import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.bean.role.RoleData;
import com.cskaoyan.malladmin.bean.role.RoleOption;
import com.cskaoyan.malladmin.mapper.role.RoleMapper;
import com.cskaoyan.malladmin.service.role.RoleService;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/22 21:51
 */
@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  RoleMapper roleMapper;

  @Override
  public QueryVo queryRoleOPtions() {
    List<RoleOption> roleOptions = roleMapper.queryOptions();
    QueryVo queryVo = new QueryVo();
    queryVo.setErrno(0);
    queryVo.setErrmsg("成功");
    queryVo.setData(roleOptions);

    return queryVo;
  }

  @Override
  public QueryVo queryRolePageByName(int page,int limit,String name) {

    QueryVo queryVo = new QueryVo();
    RoleData roleData = new RoleData();

    //名称模糊查询
    List<Role> roles = roleMapper.queryByName(name);

    //分页
    PageHelper.startPage(page,limit);

    //roleData存入信息
    roleData.setItems(roles);
    roleData.setTotal(roles.size());

    //queryVo存入信息
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    queryVo.setData(roleData);

    return queryVo;
  }

  @Override
  public QueryVo updateRole(Role role) {

    QueryVo queryVo = new QueryVo();

    //设定更新时间
    role.setUpdateTime(new Date());

    int i = roleMapper.updateRole(role);

    if(i==0){
      queryVo.setErrmsg("更新异常");
      queryVo.setErrno(0);
    }

    //成功封装并返回
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    return queryVo;
  }

  @Override
  public QueryVo deleteRole(Integer id) {
    QueryVo queryVo = new QueryVo();
    int i = roleMapper.deleteById(id);
    if(i==0){
      queryVo.setErrno(0);
      queryVo.setErrmsg("删除失败");
    }
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    return queryVo;
  }

  @Override
  public QueryVo insertRole(Role role) {

    //检测角色重复
    QueryVo queryVo = new QueryVo();
    List<Role> rolesOld = roleMapper.queryByName(role.getName());
    if(rolesOld.size()!=0){
      queryVo.setErrno(640);
      queryVo.setErrmsg("角色已经存在");
      return queryVo;
    }

    //设定插入时间
    role.setAddTime(new Date());

    //插入角色
    int i = roleMapper.insertRole(role);
    if(i==0){
      queryVo.setErrmsg("插入异常");
      queryVo.setErrno(0);
    }

    //查询并封装
    Role rolesNew = roleMapper.queryOneByName(role.getName());
    queryVo.setData(rolesNew);
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);

    return queryVo;
  }

  @Override
  public QueryVo queryRolePage(int page, int limit) {
    List<Role> roles = roleMapper.queryList();
    PageHelper.startPage(page, limit);
    QueryVo queryVo = new QueryVo();
    RoleData roleData = new RoleData();
    roleData.setLimit(limit);
    roleData.setItems(roles);
    roleData.setTotal(roles.size());

    queryVo.setData(roleData);
    queryVo.setErrno(0);
    queryVo.setErrmsg("成功");

    return queryVo;
  }

}
