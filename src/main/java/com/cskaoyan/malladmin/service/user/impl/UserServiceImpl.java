package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserPage;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.UserService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public PageHandler selectAllUser(QueryIn queryIn ,String username,String mobile){
        int total=userMapper.queryUserCount(username,mobile);
        PageHandler pageHandler=new PageHandler();
        if(username!=null && !"".equals(username)){
            username="%"+username+"%";
        }

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<User> list=userMapper.selectAllUser(queryIn.getSort(),queryIn.getOrder(),username,mobile);

        pageHandler.setTotal(total);
        pageHandler.setItems(list);

        return pageHandler;
    }

}
