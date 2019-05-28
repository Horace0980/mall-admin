package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.service.goods.CommentService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 22:51
 */
@RestController
public class WxCommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping("wx/comment/list")

    public QueryVo list(String valueId, String type, String showType, String page, String size){

        QueryVo list = commentService.list(valueId,type,showType,page,size);
        return list;

    }

    @RequestMapping("wx/comment/count")
    public QueryVo count(String valueId, String type){
        QueryVo count = commentService.count(valueId,type);
        return count;
    }
}
