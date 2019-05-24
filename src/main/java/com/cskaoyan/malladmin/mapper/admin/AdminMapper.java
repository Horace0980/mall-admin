package com.cskaoyan.malladmin.mapper.admin;

import com.cskaoyan.malladmin.bean.admin.Admin;
import com.cskaoyan.malladmin.bean.admin.AdminExample;
import com.cskaoyan.malladmin.bean.admin.AdminItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<AdminItem> queryList();

    int insertAdminItem(AdminItem adminItem);

    List<AdminItem> queryByUsername(@Param("name")String name);

    Admin selectByUsername(String username);

    int updateAdmin(@Param("adminItem") AdminItem adminItem);

    AdminItem queryById(@Param("id") int id);

    Admin selectByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
