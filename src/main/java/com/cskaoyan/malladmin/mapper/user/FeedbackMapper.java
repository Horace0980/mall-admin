package com.cskaoyan.malladmin.mapper.user;

import com.cskaoyan.malladmin.bean.user.Feedback;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:13
 */
public interface FeedbackMapper {

    int queryFeedbackCount(@Param("username") String name, @Param("id") int ui);

    List<Feedback> selectAllFeedback(@Param("sort") String sort, @Param("order") String o, @Param("username") String name, @Param("id") int ui);

    //查询所有的user
    List<Feedback> selectAll();


}
