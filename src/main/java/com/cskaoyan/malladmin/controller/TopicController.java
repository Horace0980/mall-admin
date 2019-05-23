package com.cskaoyan.malladmin.controller;


import com.cskaoyan.malladmin.bean.topic.Topic;
import com.cskaoyan.malladmin.service.topic.TopicService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc
 * @Date: 2019/5/23 15:16
 */
@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("list")
    public QueryVo list(QueryIn queryIn,String title,String subtitle){
        return topicService.getByCondition(queryIn,title,subtitle);
    }
    @RequestMapping("create")
    public QueryVo addNew(@RequestBody Topic topic){
        return topicService.addNew(topic);
    }
    @RequestMapping("update")
    public QueryVo update(@RequestBody Topic topic){
        return topicService.update(topic);
    }
    @RequestMapping("delete")
    public QueryVo delete(@RequestBody Topic topic){
        return topicService.delete(topic);
    }
}
