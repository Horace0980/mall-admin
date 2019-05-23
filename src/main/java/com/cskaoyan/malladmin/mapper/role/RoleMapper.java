package com.cskaoyan.malladmin.mapper.role;

import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.bean.role.RoleExample;
import com.cskaoyan.malladmin.bean.role.RoleOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    Role selectByPrimaryKey(Integer id);
    List<Role> queryList();
    List<RoleOption> queryOptions();
}
