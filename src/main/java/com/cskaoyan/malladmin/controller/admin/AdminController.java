package com.cskaoyan.malladmin.controller.admin;

import com.cskaoyan.malladmin.bean.admin.Admin;
import com.cskaoyan.malladmin.bean.admin.AdminItem;
import com.cskaoyan.malladmin.service.admin.AdminService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Author: yyc
 * @Date: 2019/5/22 13:18
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("auth/login")
    public QueryVo login(@RequestBody Admin admin, HttpServletRequest request){
        QueryVo login = adminService.login(admin,request);
        return login;
    }

    @RequestMapping("auth/info")
    public QueryVo toInfo(String token,HttpServletRequest request){
        HttpSession session = request.getSession();

        String token1 = (String) session.getAttribute("token");
//        if (token1==null || !token1.equals(token)){
//            return new QueryVo(0,null,"please Log in");
//        }
        Admin admin = (Admin) session.getAttribute("admin");
        return adminService.getInfo(admin);
    }

    @RequestMapping("admin/list")
    public QueryVo adminList(int page, int limit,String username){
      if(username!=null){
        QueryVo queryVo = adminService.queryAdminPageByName(page, limit, "%"+username+"%");
        return queryVo;
      }
      QueryVo queryVo = adminService.queryAdminPage(page, limit);

      return queryVo;
    }

    @RequestMapping("admin/create")
    public QueryVo createAdmin(@RequestBody AdminItem admin){

      QueryVo queryVo = new QueryVo();

      //用户名校验，只可以有中文英文和汉字
      String namePattern = "^[a-zA-Z0-9_\\u4e00-\\u9fa5]+$";
      if(!Pattern.matches(namePattern,admin.getUsername())){
        queryVo.setErrno(601);
        queryVo.setErrmsg("用户名不符合规定");
        return queryVo;
      }
      //密码校验，长度不小于6
      if (admin.getPassword().length()<6){
        queryVo.setErrno(602);
        queryVo.setErrmsg("管理员密码不得小于6!");
        return queryVo;
      }

      //防重复校验
      boolean b = adminService.QueryAdminName(admin.getUsername());
      if(b){
        queryVo.setErrno(602);
        queryVo.setErrmsg("管理员已存在！");
        return queryVo;
      }


      admin.setAddTime(new Date());
      admin.setUpdateTime(new Date());
      //插入返回
      boolean addAdmin = adminService.addAdmin(admin);
      if(addAdmin){
        queryVo.setErrno(0);
        queryVo.setErrmsg("成功");
        queryVo.setData(admin);
        return queryVo;
      }

      queryVo.setErrmsg("插入异常！");
      queryVo.setErrno(602);
      return queryVo;
    }

    @RequestMapping("admin/update")
    public QueryVo updateAdmin(@RequestBody AdminItem admin){
      QueryVo queryVo1 = adminService.updateAdmin(admin);
      return queryVo1;
    }

    @RequestMapping("admin/delete")
    public QueryVo deleteAdmin(@RequestBody AdminItem admin){
      QueryVo queryVo = adminService.deleteAdmin(admin);
      return queryVo;
    }

}
