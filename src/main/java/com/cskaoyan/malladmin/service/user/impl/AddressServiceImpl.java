package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.Address;
import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserPage;
import com.cskaoyan.malladmin.mapper.market.RegionMapper;
import com.cskaoyan.malladmin.mapper.user.AddressMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.AddressService;
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
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Autowired
    RegionMapper regionMapper;

    @Override
    public PageHandler selectAllAddress(QueryIn queryIn ,String name,String userId){
        if(name!=null && !"".equals(name)){
            name="%"+name+"%";
        }
        int ui=userId!=null? Integer.parseInt(userId):0;
        int total=addressMapper.queryAddressCount(name,ui);
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Address> list=addressMapper.selectAllAddress(queryIn.getSort(),queryIn.getOrder(),name,ui);

        list=getList(list);
        pageHandler.setItems(list);

        return pageHandler;
    }

    public List<Address> getList(List<Address> list){
        for(Address add:list){
            int cid=add.getCityId();
            int pid=add.getProvinceId();
            int aid=add.getAreaId();
            String city=regionMapper.queryCityById(cid);
            String province=regionMapper.queryProvinceById(pid);
            String area=regionMapper.queryAreaById(aid);
            add.setCity(city);
            add.setProvince(province);
            add.setArea(area);
        }
        return list;
    }

}
