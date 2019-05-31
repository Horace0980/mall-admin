package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.market.Order;
import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserRegister;
import com.cskaoyan.malladmin.mapper.market.OrderMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.UserService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;
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

    @Override
    public User register(UserRegister user, String ip) {
        User register = new User();

        register.setUsername(user.getUsername());
        register.setNickname(user.getUsername());
        register.setPassword(user.getPassword());
        register.setAddTime(new Date());
        register.setUpdateTime(new Date());
        register.setGender(1);
        register.setUserLevel(0);
        register.setDeleted(false);
        register.setStatus(0);
        register.setLastLoginIp(ip);
        register.setMobile(user.getMobile());

        int count =  userMapper.queryUserByMobile(user.getMobile());

        User userInfo = new User();
        if (count == 0){
            int isRe = userMapper.register(register);

            if (isRe ==1){
                userInfo = register;
            }

        }


        return userInfo;

    }

    @Override
    public User login(User users, String ip) {



        User user = userMapper.getUser(users.getUsername(),users.getPassword());
        if (user!=null){
            userMapper.updateIp(ip,user.getUsername(),user.getPassword());
        }

        return user;
    }

    @Override
    public QueryVo index(String ip) {

        User user = userMapper.queruUserByIp(ip);
        Order order = orderMapper.getOrderDetailByUserId(user.getId());
        HashMap<Object, Object> map = new HashMap<>();
        map.put("order",order);
        return new QueryVo(0,map,"success");
    }

    @Override
    public QueryVo reset(UserRegister userRegister) {
        QueryVo queryVo = new QueryVo();

        int isUp = userMapper.updatePassword(userRegister.getPassword(),userRegister.getMobile());

        if (isUp ==1){
            queryVo = new QueryVo(0,null,"success");
        }else {
            queryVo = new QueryVo(605,null,"failed");
        }

        return queryVo;

    }

}
