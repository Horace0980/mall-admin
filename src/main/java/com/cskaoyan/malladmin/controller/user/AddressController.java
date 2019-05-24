package com.cskaoyan.malladmin.controller.user;

import com.cskaoyan.malladmin.service.user.AddressService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:12
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/list")
    public QueryVo selectAllAddress(QueryIn queryIn,String name,int userId){
        PageHandler pageHandler=null;
        pageHandler= addressService.selectAllAddress(queryIn,name,userId);

        return new QueryVo(0,pageHandler,"成功");
    }

}
