package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface CollectMapper {

    int queryCollectCount();

    List<Collect> selectAllCollect(@Param("sort") String sort, @Param("order") String o, @Param("start") int s, @Param("rows") int l, @Param("valueid")int vi, @Param("userid") int ui);

    //查询所有的user
    List<Collect> selectAll();


}
