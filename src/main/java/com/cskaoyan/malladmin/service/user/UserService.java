package com.cskaoyan.malladmin.service.user;

import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
public interface UserService {
    PageHandler selectAllUser(QueryIn queryIn);
}
