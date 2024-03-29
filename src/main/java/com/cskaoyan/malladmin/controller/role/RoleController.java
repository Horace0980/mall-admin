package com.cskaoyan.malladmin.controller.role;

import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.service.role.RoleService;
import com.cskaoyan.malladmin.utils.JsonDateValueProcessor;
import com.cskaoyan.malladmin.vo.QueryVo;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @Author: Dankin
 * @Date: 2019/5/22 21:48
 */
@RestController
@RequestMapping("admin")
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

  @RequestMapping("role/permissions")
  public String Buhuizuo(){
    return "{\"errno\":0,\"data\":{\"systemPermissions\":[{\"id\":\"商品管理\",\"label\":\"商品管理\",\"children\":[{\"id\":\"评论管理\",\"label\":\"评论管理\",\"children\":[{\"id\":\"admin:comment:delete\",\"label\":\"删除\",\"api\":\"POST /admin/comment/delete\"},{\"id\":\"admin:comment:list\",\"label\":\"查询\",\"api\":\"GET /admin/comment/list\"}]},{\"id\":\"商品管理\",\"label\":\"商品管理\",\"children\":[{\"id\":\"admin:goods:read\",\"label\":\"详情\",\"api\":\"GET /admin/goods/detail\"},{\"id\":\"admin:goods:update\",\"label\":\"编辑\",\"api\":\"POST /admin/goods/update\"},{\"id\":\"admin:goods:delete\",\"label\":\"删除\",\"api\":\"POST /admin/goods/delete\"},{\"id\":\"admin:goods:create\",\"label\":\"上架\",\"api\":\"POST /admin/goods/create\"},{\"id\":\"admin:goods:list\",\"label\":\"查询\",\"api\":\"GET /admin/goods/list\"}]}]},{\"id\":\"用户管理\",\"label\":\"用户管理\",\"children\":[{\"id\":\"搜索历史\",\"label\":\"搜索历史\",\"children\":[{\"id\":\"admin:history:list\",\"label\":\"查询\",\"api\":\"GET /admin/history/list\"}]},{\"id\":\"收货地址\",\"label\":\"收货地址\",\"children\":[{\"id\":\"admin:address:list\",\"label\":\"查询\",\"api\":\"GET /admin/address/list\"}]},{\"id\":\"意见反馈\",\"label\":\"意见反馈\",\"children\":[{\"id\":\"admin:feedback:list\",\"label\":\"查询\",\"api\":\"GET /admin/feedback/list\"}]},{\"id\":\"会员管理\",\"label\":\"会员管理\",\"children\":[{\"id\":\"admin:user:list\",\"label\":\"查询\",\"api\":\"GET /admin/user/list\"}]},{\"id\":\"用户足迹\",\"label\":\"用户足迹\",\"children\":[{\"id\":\"admin:footprint:list\",\"label\":\"查询\",\"api\":\"GET /admin/footprint/list\"}]},{\"id\":\"用户收藏\",\"label\":\"用户收藏\",\"children\":[{\"id\":\"admin:collect:list\",\"label\":\"查询\",\"api\":\"GET /admin/collect/list\"}]}]},{\"id\":\"系统管理\",\"label\":\"系统管理\",\"children\":[{\"id\":\"角色管理\",\"label\":\"角色管理\",\"children\":[{\"id\":\"admin:role:permission:update\",\"label\":\"权限变更\",\"api\":\"POST /admin/role/permissions\"},{\"id\":\"admin:role:update\",\"label\":\"角色编辑\",\"api\":\"POST /admin/role/update\"},{\"id\":\"admin:role:read\",\"label\":\"角色详情\",\"api\":\"GET /admin/role/read\"},{\"id\":\"admin:role:delete\",\"label\":\"角色删除\",\"api\":\"POST /admin/role/delete\"},{\"id\":\"admin:role:permission:get\",\"label\":\"权限详情\",\"api\":\"GET /admin/role/permissions\"},{\"id\":\"admin:role:create\",\"label\":\"角色添加\",\"api\":\"POST /admin/role/create\"},{\"id\":\"admin:role:list\",\"label\":\"角色查询\",\"api\":\"GET /admin/role/list\"}]},{\"id\":\"对象存储\",\"label\":\"对象存储\",\"children\":[{\"id\":\"admin:storage:update\",\"label\":\"编辑\",\"api\":\"POST /admin/storage/update\"},{\"id\":\"admin:storage:read\",\"label\":\"详情\",\"api\":\"POST /admin/storage/read\"},{\"id\":\"admin:storage:delete\",\"label\":\"删除\",\"api\":\"POST /admin/storage/delete\"},{\"id\":\"admin:storage:create\",\"label\":\"上传\",\"api\":\"POST /admin/storage/create\"},{\"id\":\"admin:storage:list\",\"label\":\"查询\",\"api\":\"GET /admin/storage/list\"}]},{\"id\":\"管理员管理\",\"label\":\"管理员管理\",\"children\":[{\"id\":\"admin:admin:update\",\"label\":\"编辑\",\"api\":\"POST /admin/admin/update\"},{\"id\":\"admin:admin:read\",\"label\":\"详情\",\"api\":\"GET /admin/admin/read\"},{\"id\":\"admin:admin:delete\",\"label\":\"删除\",\"api\":\"POST /admin/admin/delete\"},{\"id\":\"admin:admin:create\",\"label\":\"添加\",\"api\":\"POST /admin/admin/create\"},{\"id\":\"admin:admin:list\",\"label\":\"查询\",\"api\":\"GET /admin/admin/list\"}]},{\"id\":\"操作日志\",\"label\":\"操作日志\",\"children\":[{\"id\":\"admin:log:list\",\"label\":\"查询\",\"api\":\"GET /admin/log/list\"}]}]},{\"id\":\"推广管理\",\"label\":\"推广管理\",\"children\":[{\"id\":\"优惠券管理\",\"label\":\"优惠券管理\",\"children\":[{\"id\":\"admin:coupon:listuser\",\"label\":\"查询用户\",\"api\":\"GET /admin/coupon/listuser\"},{\"id\":\"admin:coupon:update\",\"label\":\"编辑\",\"api\":\"POST /admin/coupon/update\"},{\"id\":\"admin:coupon:read\",\"label\":\"详情\",\"api\":\"GET /admin/coupon/read\"},{\"id\":\"admin:coupon:delete\",\"label\":\"删除\",\"api\":\"POST /admin/coupon/delete\"},{\"id\":\"admin:coupon:create\",\"label\":\"添加\",\"api\":\"POST /admin/coupon/create\"},{\"id\":\"admin:coupon:list\",\"label\":\"查询\",\"api\":\"GET /admin/coupon/list\"}]},{\"id\":\"专题管理\",\"label\":\"专题管理\",\"children\":[{\"id\":\"admin:topic:update\",\"label\":\"编辑\",\"api\":\"POST /admin/topic/update\"},{\"id\":\"admin:topic:read\",\"label\":\"详情\",\"api\":\"GET /admin/topic/read\"},{\"id\":\"admin:topic:delete\",\"label\":\"删除\",\"api\":\"POST /admin/topic/delete\"},{\"id\":\"admin:topic:create\",\"label\":\"添加\",\"api\":\"POST /admin/topic/create\"},{\"id\":\"admin:topic:list\",\"label\":\"查询\",\"api\":\"GET /admin/topic/list\"}]},{\"id\":\"团购管理\",\"label\":\"团购管理\",\"children\":[{\"id\":\"admin:groupon:read\",\"label\":\"详情\",\"api\":\"GET /admin/groupon/listRecord\"},{\"id\":\"admin:groupon:update\",\"label\":\"编辑\",\"api\":\"POST /admin/groupon/update\"},{\"id\":\"admin:groupon:delete\",\"label\":\"删除\",\"api\":\"POST /admin/groupon/delete\"},{\"id\":\"admin:groupon:create\",\"label\":\"添加\",\"api\":\"POST /admin/groupon/create\"},{\"id\":\"admin:groupon:list\",\"label\":\"查询\",\"api\":\"GET /admin/groupon/list\"}]},{\"id\":\"广告管理\",\"label\":\"广告管理\",\"children\":[{\"id\":\"admin:ad:update\",\"label\":\"编辑\",\"api\":\"POST /admin/ad/update\"},{\"id\":\"admin:ad:read\",\"label\":\"详情\",\"api\":\"GET /admin/ad/read\"},{\"id\":\"admin:ad:delete\",\"label\":\"删除\",\"api\":\"POST /admin/ad/delete\"},{\"id\":\"admin:ad:create\",\"label\":\"添加\",\"api\":\"POST /admin/ad/create\"},{\"id\":\"admin:ad:list\",\"label\":\"查询\",\"api\":\"GET /admin/ad/list\"}]}]},{\"id\":\"商场管理\",\"label\":\"商场管理\",\"children\":[{\"id\":\"通用问题\",\"label\":\"通用问题\",\"children\":[{\"id\":\"admin:issue:update\",\"label\":\"编辑\",\"api\":\"POST /admin/issue/update\"},{\"id\":\"admin:issue:delete\",\"label\":\"删除\",\"api\":\"POST /admin/issue/delete\"},{\"id\":\"admin:issue:create\",\"label\":\"添加\",\"api\":\"POST /admin/issue/create\"},{\"id\":\"admin:issue:list\",\"label\":\"查询\",\"api\":\"GET /admin/issue/list\"}]},{\"id\":\"关键词\",\"label\":\"关键词\",\"children\":[{\"id\":\"admin:keyword:update\",\"label\":\"编辑\",\"api\":\"POST /admin/keyword/update\"},{\"id\":\"admin:keyword:read\",\"label\":\"详情\",\"api\":\"GET /admin/keyword/read\"},{\"id\":\"admin:keyword:delete\",\"label\":\"删除\",\"api\":\"POST /admin/keyword/delete\"},{\"id\":\"admin:keyword:create\",\"label\":\"添加\",\"api\":\"POST /admin/keyword/create\"},{\"id\":\"admin:keyword:list\",\"label\":\"查询\",\"api\":\"GET /admin/keyword/list\"}]},{\"id\":\"品牌管理\",\"label\":\"品牌管理\",\"children\":[{\"id\":\"admin:brand:update\",\"label\":\"编辑\",\"api\":\"POST /admin/brand/update\"},{\"id\":\"admin:brand:read\",\"label\":\"详情\",\"api\":\"GET /admin/brand/read\"},{\"id\":\"admin:brand:delete\",\"label\":\"删除\",\"api\":\"POST /admin/brand/delete\"},{\"id\":\"admin:brand:create\",\"label\":\"添加\",\"api\":\"POST /admin/brand/create\"},{\"id\":\"admin:brand:list\",\"label\":\"查询\",\"api\":\"GET /admin/brand/list\"}]},{\"id\":\"订单管理\",\"label\":\"订单管理\",\"children\":[{\"id\":\"admin:order:refund\",\"label\":\"订单退款\",\"api\":\"POST /admin/order/refund\"},{\"id\":\"admin:order:ship\",\"label\":\"订单发货\",\"api\":\"POST /admin/order/ship\"},{\"id\":\"admin:order:read\",\"label\":\"详情\",\"api\":\"GET /admin/order/detail\"},{\"id\":\"admin:order:reply\",\"label\":\"订单商品回复\",\"api\":\"POST /admin/order/reply\"},{\"id\":\"admin:order:list\",\"label\":\"查询\",\"api\":\"GET /admin/order/list\"}]},{\"id\":\"类目管理\",\"label\":\"类目管理\",\"children\":[{\"id\":\"admin:wxCategory:update\",\"label\":\"编辑\",\"api\":\"POST /admin/wxCategory/update\"},{\"id\":\"admin:wxCategory:read\",\"label\":\"详情\",\"api\":\"GET /admin/wxCategory/read\"},{\"id\":\"admin:wxCategory:delete\",\"label\":\"删除\",\"api\":\"POST /admin/wxCategory/delete\"},{\"id\":\"admin:wxCategory:create\",\"label\":\"添加\",\"api\":\"POST /admin/wxCategory/create\"},{\"id\":\"admin:wxCategory:list\",\"label\":\"查询\",\"api\":\"GET /admin/wxCategory/list\"}]}]},{\"id\":\"配置管理\",\"label\":\"配置管理\",\"children\":[{\"id\":\"商场配置\",\"label\":\"商场配置\",\"children\":[{\"id\":\"admin:config:mall:list\",\"label\":\"详情\",\"api\":\"GET /admin/config/mall\"},{\"id\":\"admin:config:mall:updateConfigs\",\"label\":\"编辑\",\"api\":\"POST /admin/config/mall\"}]},{\"id\":\"订单配置\",\"label\":\"订单配置\",\"children\":[{\"id\":\"admin:config:order:list\",\"label\":\"详情\",\"api\":\"GET /admin/config/order\"},{\"id\":\"admin:config:order:updateConfigs\",\"label\":\"编辑\",\"api\":\"POST /admin/config/order\"}]},{\"id\":\"小程序配置\",\"label\":\"小程序配置\",\"children\":[{\"id\":\"admin:config:wx:updateConfigs\",\"label\":\"编辑\",\"api\":\"POST /admin/config/wx\"},{\"id\":\"admin:config:wx:list\",\"label\":\"详情\",\"api\":\"GET /admin/config/wx\"}]},{\"id\":\"运费配置\",\"label\":\"运费配置\",\"children\":[{\"id\":\"admin:config:express:list\",\"label\":\"详情\",\"api\":\"GET /admin/config/express\"},{\"id\":\"admin:config:express:updateConfigs\",\"label\":\"编辑\",\"api\":\"POST /admin/config/express\"}]}]},{\"id\":\"其他\",\"label\":\"其他\",\"children\":[{\"id\":\"权限测试\",\"label\":\"权限测试\",\"children\":[{\"id\":\"index:permission:write\",\"label\":\"权限写\",\"api\":\"POST /admin/index/write\"},{\"id\":\"index:permission:read\",\"label\":\"权限读\",\"api\":\"GET /admin/index/read\"}]}]},{\"id\":\"统计管理\",\"label\":\"统计管理\",\"children\":[{\"id\":\"用户统计\",\"label\":\"用户统计\",\"children\":[{\"id\":\"admin:stat:user\",\"label\":\"查询\",\"api\":\"GET /admin/stat/user\"}]},{\"id\":\"订单统计\",\"label\":\"订单统计\",\"children\":[{\"id\":\"admin:stat:order\",\"label\":\"查询\",\"api\":\"GET /admin/stat/order\"}]},{\"id\":\"商品统计\",\"label\":\"商品统计\",\"children\":[{\"id\":\"admin:stat:goods\",\"label\":\"查询\",\"api\":\"GET /admin/stat/goods\"}]}]}],\"assignedPermissions\":[\"admin:order:list\",\"admin:admin:update\",\"admin:coupon:delete\",\"admin:topic:read\",\"admin:admin:delete\",\"admin:user:list\",\"admin:goods:update\",\"admin:role:permission:get\",\"admin:brand:update\",\"admin:wxCategory:create\",\"admin:coupon:list\",\"admin:ad:create\",\"admin:stat:order\",\"admin:config:wx:updateConfigs\",\"admin:topic:list\",\"admin:order:refund\",\"admin:order:read\",\"admin:topic:delete\",\"admin:brand:list\",\"admin:coupon:update\",\"admin:brand:delete\",\"admin:brand:read\",\"admin:config:wx:list\",\"admin:collect:list\",\"admin:storage:list\",\"admin:coupon:listuser\",\"admin:groupon:read\",\"admin:admin:read\",\"admin:storage:read\",\"admin:order:ship\",\"admin:keyword:update\",\"admin:comment:delete\",\"admin:groupon:create\",\"admin:comment:list\",\"admin:keyword:list\",\"admin:keyword:create\",\"admin:admin:list\",\"admin:history:list\",\"admin:wxCategory:delete\",\"admin:role:delete\",\"admin:storage:delete\",\"admin:keyword:read\",\"admin:order:reply\",\"admin:goods:delete\",\"admin:ad:delete\",\"admin:issue:update\",\"admin:address:list\",\"admin:topic:create\",\"admin:wxCategory:read\",\"admin:wxCategory:update\",\"admin:storage:create\",\"admin:config:express:updateConfigs\",\"admin:brand:create\",\"admin:issue:delete\",\"admin:config:express:list\",\"admin:goods:create\",\"admin:ad:list\",\"admin:role:permission:update\",\"admin:groupon:list\",\"admin:admin:create\",\"admin:groupon:update\",\"admin:footprint:list\",\"index:permission:write\",\"admin:groupon:delete\",\"admin:ad:read\",\"admin:config:order:list\",\"index:permission:read\",\"admin:keyword:delete\",\"admin:role:create\",\"admin:issue:list\",\"admin:log:list\",\"admin:config:order:updateConfigs\",\"admin:topic:update\",\"admin:config:mall:list\",\"admin:wxCategory:list\",\"admin:stat:goods\",\"admin:issue:create\",\"admin:role:update\",\"admin:config:mall:updateConfigs\",\"admin:stat:user\",\"admin:coupon:read\",\"admin:coupon:create\",\"admin:goods:list\",\"admin:ad:update\",\"admin:role:list\",\"admin:storage:update\",\"admin:role:read\",\"admin:feedback:list\",\"admin:goods:read\"]},\"errmsg\":\"成功\"}";
  }
}
