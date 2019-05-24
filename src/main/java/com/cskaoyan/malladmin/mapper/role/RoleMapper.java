package com.cskaoyan.malladmin.mapper.role;

import com.cskaoyan.malladmin.bean.role.Role;
import com.cskaoyan.malladmin.bean.role.RoleExample;
import com.cskaoyan.malladmin.bean.role.RoleOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    Role selectByPrimaryKey(@Param("id") Integer id);

    List<Role> queryList();

    List<RoleOption> queryOptions();

    List<Role> queryByName(@Param("name") String name);

    int insertRole(@Param("roleCreate") Role role);

    Role queryOneByName(@Param("name") String name);

    int updateRole(@Param("role") Role role);

    int deleteById(@Param("id") Integer id);
}
