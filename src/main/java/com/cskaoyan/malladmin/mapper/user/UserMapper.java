package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface UserMapper {

    int queryUserCount();

    List<User> selectAllUser(@Param("sort") String sort,@Param("order") String o,@Param("start")int s,@Param("rows")int l,@Param("username")String name,@Param("mobile")String m);

    //查询所有的user
    List<User> selectAll();

    User queryUserById(@Param("id") int id);


}
