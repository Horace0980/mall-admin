package com.cskaoyan.malladmin.service.admin.impl;

import com.cskaoyan.malladmin.bean.admin.*;
import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.mapper.admin.AdminMapper;
import com.cskaoyan.malladmin.mapper.role.RoleMapper;
import com.cskaoyan.malladmin.service.admin.AdminService;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author: yyc
 * @Date: 2019/5/22 15:01
 */
@Service
public class AdminServiceImpl implements AdminService {



  @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;

  @Override
  public boolean addAdmin(AdminItem admin) {
    System.out.println(admin);
    int i = adminMapper.insertAdminItem(admin);
    return i!=0;
  }

  @Override
  public QueryVo deleteAdmin(AdminItem adminItem) {
    QueryVo queryVo = new QueryVo();
    int i = adminMapper.deleteByPrimaryKey(adminItem.getId());
    if (i==0){
      queryVo.setErrmsg("删除异常");
      queryVo.setErrno(602);
    }
    queryVo.setErrno(0);
    queryVo.setErrmsg("成功！");
    return queryVo;
  }

  @Override
  public boolean QueryAdminName(String name) {
    Admin admin = adminMapper.selectByUsername(name);
    return admin!=null;
  }

  @Override
  public QueryVo updateAdmin(AdminItem adminItem) {
    int i = adminMapper.updateAdmin(adminItem);
    adminItem.setUpdateTime(new Date());
    QueryVo queryVo = new QueryVo();
    if(i==0){
      queryVo.setErrmsg("更新失败");
      queryVo.setErrno(0);
      queryVo.setData(adminItem);
    }
    AdminItem adminItem1 = adminMapper.queryById(adminItem.getId());
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    queryVo.setData(adminItem1);

    return queryVo;
  }

  @Override
  public QueryVo queryAdminPageByName(int page, int limit, String name) {
    List<AdminItem> adminItem = adminMapper.queryByUsername(name);
    PageHelper.startPage(page,limit);
    AdminData adminData = new AdminData();

    adminData.setTotal(adminItem.size());
    adminData.setItems(adminItem);
    QueryVo queryVo = new QueryVo();
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    queryVo.setData(adminData);

    return queryVo;
  }

  @Override
  public QueryVo queryAdminPage(int page, int limit) {
    //获取链表
    List<AdminItem> admins = adminMapper.queryList();

    //分页
    PageHelper.startPage(page,limit);

    //封装data对象
    AdminData adminData = new AdminData();
    adminData.setItems(admins);
    adminData.setTotal(admins.size());

    //封装QueryVo对象
    QueryVo queryVo = new QueryVo();
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    queryVo.setData(adminData);

    return queryVo;
  }

  private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public QueryVo login(Admin admin, HttpServletRequest request) {
        Admin adminByUsername = adminMapper.selectByUsername(admin.getUsername());
        if (adminByUsername ==null){
            return new QueryVo(605,null,"用户名不存在");
        }
        String rawPassword = admin.getPassword();
       if (!bCryptPasswordEncoder.matches(rawPassword, adminByUsername.getPassword())){
           return new QueryVo(605,null,"密码不正确");
       }else{
           HttpSession session = request.getSession();
           session.setAttribute("admin",adminByUsername);
           HashMap<String, Object> params = new HashMap<>();
           AdminInfo adminInfo = new AdminInfo();
           adminInfo.setAvatar(adminByUsername.getAvatar());
           adminInfo.setNickName(adminByUsername.getUsername());
           params.put("adminInfo",adminInfo);
           UUID value = UUID.randomUUID();
           session.setAttribute("token",value.toString());
           params.put("token", value);

           return new QueryVo(0,session.getId(),"成功");
       }


    }

    @Override
    public QueryVo getInfo(Admin admin) {
        admin = adminMapper.selectByUsername("admin123");
        HashMap<String, Object> para = new HashMap<>();
        para.put("avatar",admin.getAvatar());
        para.put("name",admin.getUsername());
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> role = new ArrayList<>();
        list.add("*");
        String roleIds = admin.getRoleIds();
//        Matcher mat = Pattern.compile("(?<=\\[)(\\S+)(?=\\])").matcher(roleIds);
//        while(mat.find()){
//
//            roleMapper.selectByPrimaryKey(roleIds)
//            role.add();
//        }
        Role role1 = roleMapper.selectByPrimaryKey(Integer.parseInt(roleIds.substring(1, 2)));

        role.add(role1.getName());
        para.put("perms",list);
        para.put("roles",role);
        return new QueryVo(0,para,"成功");

    }
}
