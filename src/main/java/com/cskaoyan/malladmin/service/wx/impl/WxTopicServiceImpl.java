package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.bean.topic.Topic;
import com.cskaoyan.malladmin.bean.topic.TopicExample;
import com.cskaoyan.malladmin.mapper.topic.TopicMapper;
import com.cskaoyan.malladmin.service.wx.WxTopicService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 21:59
 */
@Service
public class WxTopicServiceImpl implements WxTopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public QueryVo detail(String id) {

        int ids = Integer.parseInt(id);
        Topic topic = topicMapper.selectByPrimaryKey(ids);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("topic",topic);
        map.put("goods",topic.getGoods()    );

        return new QueryVo(0,map,"success");
    }

    @Override
    public QueryVo related(String id) {
        int ids = Integer.parseInt(id);

        TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andReadCountGreaterThan("60k");

        List<Topic> topics = topicMapper.selectByExample(topicExample);

        return new QueryVo(0,topics,"success");

    }
}
