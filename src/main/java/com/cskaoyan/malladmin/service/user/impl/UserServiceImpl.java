package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.User;
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
    public PageHandler selectAllUser(QueryIn queryIn){
        int page=queryIn.getPage();
        int limit=queryIn.getLimit();
        PageHandler pageHandler=new PageHandler();
        pageHandler.setpage(page);
        pageHandler.setLimit(limit);

        int total=userMapper.queryUserCount();
        pageHandler.setTotal(total);

        int pages = total%limit==0? total/limit:total/limit +1;
        pageHandler.setPages(pages);

        PageHelper.startPage(page,limit);
        List<User> list=userMapper.selectAllUser(queryIn.getSort(),queryIn.getOrder());
        pageHandler.setList(list);
        return pageHandler;
    }
}
