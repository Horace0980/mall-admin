package com.cskaoyan.malladmin.controller.goods;

import com.cskaoyan.malladmin.bean.goods.Comment;
import com.cskaoyan.malladmin.service.goods.CommentService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : zjf
 * @Date : 2019/5/23 上午 09:29
 */
@Controller

public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("admin/comment/list")
    @ResponseBody
    public QueryVo goodslist(QueryIn queryIn, Integer userId, Integer valueId){
        return commentService.allList(queryIn,userId,valueId);
    }

    @RequestMapping("admin/comment/delete")
    @ResponseBody
    public QueryVo goodlist(@RequestBody Comment comment){
        return commentService.deleteById(comment);
    }


}
