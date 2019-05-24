package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.Address;
import com.cskaoyan.malladmin.bean.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface AddressMapper {

    int queryAddressCount(@Param("name") String name, @Param("userid")int m);

    List<Address> selectAllAddress(@Param("sort") String sort, @Param("order") String o, @Param("name") String name, @Param("userid")int m);

    //查询所有的user
    List<Address> selectAll();


}
