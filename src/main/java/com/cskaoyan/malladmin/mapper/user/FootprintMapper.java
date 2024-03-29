package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.Footprint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface FootprintMapper {

    int queryFootprintCount(@Param("goodsid") int gi, @Param("userid") int ui);

    List<Footprint> selectAllFootprint(@Param("sort") String sort, @Param("order") String o, @Param("goodsid") int gi, @Param("userid") int ui);

    //查询所有的user
    List<Footprint> selectAll();


}
