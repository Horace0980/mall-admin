package com.cskaoyan.malladmin.controller.role;

import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.service.role.RoleService;
import com.cskaoyan.malladmin.util.JsonDateValueProcessor;
import com.cskaoyan.malladmin.vo.QueryVo;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @Author: Dankin
 * @Date: 2019/5/22 21:48
 */
@RestController
public class RoleController {

  @Autowired
  RoleService roleService;

  @RequestMapping("role/list")
  public JSONObject roleList(int page,int limit,String name){
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());

    if(name!=null){
      QueryVo queryVo = roleService.queryRolePageByName(page,limit,"%"+name+"%");
      JSONObject jsonObject = JSONObject.fromObject(queryVo, jsonConfig);
      return jsonObject;
    }

    QueryVo queryVo = roleService.queryRolePage(page, limit);

    JSONObject jsonObject = JSONObject.fromObject(queryVo, jsonConfig);

    return jsonObject;
  }

  @RequestMapping("role/options")
  public QueryVo roleOptions(){

    QueryVo queryVo = roleService.queryRoleOPtions();

    return queryVo;
  }

  @RequestMapping("role/create")
  public QueryVo insertRole(@RequestBody Role role){
    QueryVo queryVo = roleService.insertRole(role);
    return queryVo;
  }

  @RequestMapping("role/update")
  public QueryVo updateRole(@RequestBody Role role){
    QueryVo queryVo = roleService.updateRole(role);
    return queryVo;
  }

  @RequestMapping("role/delete")
  public QueryVo deleteRole(@RequestBody Role role){
    QueryVo queryVo = roleService.deleteRole(role.getId());
    return queryVo;
  }
}
