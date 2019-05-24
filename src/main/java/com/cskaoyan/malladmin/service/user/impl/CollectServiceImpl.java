package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.Collect;
import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserPage;
import com.cskaoyan.malladmin.mapper.user.CollectMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.CollectService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public PageHandler selectAllCollect(QueryIn queryIn ,int valueId,int userId){
        int total=collectMapper.queryCollectCount();
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        int start=UserPage.getStart(queryIn.getPage(),queryIn.getLimit(),total);

        List<Collect> list=collectMapper.selectAllCollect(queryIn.getSort(),queryIn.getOrder(),start,queryIn.getLimit(),valueId,userId);

        //list=getList(list);
        pageHandler.setItems(list);

        return pageHandler;
    }

    /*private List<Collect> getList(List<Collect> list){
        for(Collect add: list){
            int id= add.getUserId();
            User user=userMapper.queryUserById(id);
            add.setUser(user);
        }

        return list;
    }*/

}
