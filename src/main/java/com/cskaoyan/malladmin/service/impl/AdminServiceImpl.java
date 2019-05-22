package com.cskaoyan.malladmin.service.impl;

import com.cskaoyan.malladmin.bean.admin.Admin;
import com.cskaoyan.malladmin.bean.admin.AdminInfo;
import com.cskaoyan.malladmin.bean.admin.Role;
import com.cskaoyan.malladmin.mapper.admin.AdminMapper;
import com.cskaoyan.malladmin.mapper.admin.RoleMapper;
import com.cskaoyan.malladmin.service.AdminService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
