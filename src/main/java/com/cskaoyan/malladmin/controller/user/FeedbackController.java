package com.cskaoyan.malladmin.controller.user;

import com.cskaoyan.malladmin.service.user.FeedbackService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:12
 */
@RestController
@RequestMapping("admin/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/list")
    public QueryVo selectAllFeedback(QueryIn queryIn,String username,String id){
        PageHandler pageHandler=null;
        pageHandler= feedbackService.selectAllFeedback(queryIn,username,id);

        return new QueryVo(0,pageHandler,"成功");
    }

}
