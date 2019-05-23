package com.cskaoyan.malladmin.controller.role;

import com.cskaoyan.malladmin.service.role.RoleService;
import com.cskaoyan.malladmin.util.JsonDateValueProcessor;
import com.cskaoyan.malladmin.vo.QueryVo;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
  public JSONObject roleList(int page,int limit){
    JsonConfig jsonConfig = new JsonConfig();
    jsonConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor());

    QueryVo queryVo = roleService.queryRolePage(page, limit);

    JSONObject jsonObject = JSONObject.fromObject(queryVo, jsonConfig);

    return jsonObject;
  }

  @RequestMapping("role/options")
  public QueryVo roleOptions(){

    QueryVo queryVo = roleService.queryRoleOPtions();

    return queryVo;
  }

}
