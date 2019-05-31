package com.cskaoyan.malladmin.service.user;

import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserRegister;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
public interface UserService {
    PageHandler selectAllUser(QueryIn queryIn,String username,String mobile);

    User register(UserRegister user, String ip);

    User login(User user, String ip);

    QueryVo index(String ip);
}
