package com.cskaoyan.malladmin.service.goods;

import com.cskaoyan.malladmin.bean.goods.Comment;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author : zjf
 * @Date : 2019/5/23 上午 09:29
 */
public interface CommentService {
    QueryVo allList(QueryIn queryIn, Integer userId, Integer valueId);

    QueryVo deleteById(Comment comment);

    QueryVo list(String valueId, String type, String showType, String page, String size);

    QueryVo count(String valueId, String type);
}
