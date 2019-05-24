package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.Feedback;
import com.cskaoyan.malladmin.mapper.user.FeedbackMapper;
import com.cskaoyan.malladmin.service.user.FeedbackService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    

    @Override
    public PageHandler selectAllFeedback(QueryIn queryIn ,String username,String id){
        String  username1 = username!=null? "%"+username+"%":username;
        int ui=id!=null? Integer.parseInt(id):0;

        int total=feedbackMapper.queryFeedbackCount(username1,ui);
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Feedback> list=feedbackMapper.selectAllFeedback
                (queryIn.getSort(),queryIn.getOrder(),username1,ui);

        //list=getList(list);
        pageHandler.setItems(list);

        return pageHandler;
    }


}
