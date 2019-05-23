package com.cskaoyan.malladmin.mapper.system;


import com.cskaoyan.malladmin.bean.system.MallSystem;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/5/22 22:36
 */
public interface SystemMapper {
    List<MallSystem> selectMallSystemByMall(@Param("prefix") String prefix);

    int updateMallSystemBykeyName(List mallSystems);
}
