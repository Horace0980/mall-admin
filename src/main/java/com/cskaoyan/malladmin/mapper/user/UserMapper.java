package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface UserMapper {

    int queryUserCount(@Param("username") String name, @Param("mobile") String m);

    List<User> selectAllUser(@Param("sort") String sort, @Param("order") String o, @Param("username") String name, @Param("mobile") String m);

    List<User> selectAll();


    int getUserTotal();


    User getUser(String username, String password);

    int register(User register);

    void updateIp(String ip, String username, String password);

    User queruUserByIp(String ip);
}
