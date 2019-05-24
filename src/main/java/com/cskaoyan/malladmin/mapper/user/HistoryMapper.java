package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.Feedback;
import com.cskaoyan.malladmin.bean.user.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface HistoryMapper {

    int queryHistoryCount(@Param("keyword") String name, @Param("userid") int ui);

    List<History> selectAllHistory(@Param("sort") String sort, @Param("order") String o, @Param("keyword") String name, @Param("userid") int ui);

    //查询所有的user
    List<History> selectAll();


}
