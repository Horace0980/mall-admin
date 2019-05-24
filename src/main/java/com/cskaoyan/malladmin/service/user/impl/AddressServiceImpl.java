package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.Address;
import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserPage;
import com.cskaoyan.malladmin.mapper.user.AddressMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.AddressService;
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
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public PageHandler selectAllAddress(QueryIn queryIn ,String name,int userId){
        int total=addressMapper.queryAddressCount();
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        if(name!=null && !"".equals(name)){
            name="%"+name+"%";
        }
        int start=UserPage.getStart(queryIn.getPage(),queryIn.getLimit(),total);

        List<Address> list=addressMapper.selectAllAddress(queryIn.getSort(),queryIn.getOrder(),start,queryIn.getLimit(),name,userId);

        list=getList(list);
        pageHandler.setItems(list);

        return pageHandler;
    }

    private List<Address> getList(List<Address> list){
        for(Address add: list){
            int id= add.getUserId();
            User user=userMapper.queryUserById(id);
            add.setUser(user);
        }

        return list;
    }

}
