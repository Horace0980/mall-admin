package com.cskaoyan.malladmin.service.topic.impl;

import com.cskaoyan.malladmin.bean.topic.Topic;
import com.cskaoyan.malladmin.bean.topic.TopicExample;
import com.cskaoyan.malladmin.mapper.topic.TopicMapper;
import com.cskaoyan.malladmin.service.topic.TopicService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/23 15:17
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public QueryVo getByCondition(QueryIn queryIn, String title, String subtitle) {
        TopicExample topicExample = new TopicExample();
        topicExample.setOrderByClause(queryIn.getSort()+" "+queryIn.getOrder());
        TopicExample.Criteria or = topicExample.or();
        if (title!=null && title.trim().length()>0){
            or.andTitleLike("%"+title+"%");
        }
        if (subtitle!=null && subtitle.trim().length()>0){
            or.andSubtitleLike("%"+subtitle+"%");
        }

        long l = topicMapper.countByExample(topicExample);
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",topics);
        map.put("total",l);
        return new QueryVo(0,map,"成功");
    }

    @Override
    public QueryVo addNew(Topic topic) {
        Date addTime = new Date();
        topic.setAddTime(addTime);
        topic.setDeleted(false);
        topic.setUpdateTime(addTime);
        int res = topicMapper.insertSelective(topic);
        if (res==1)
            return new QueryVo(0,topic,"成功");
        else return new QueryVo(605,null,"网络异常");
    }

    @Override
    public QueryVo update(Topic topic) {
        topic.setUpdateTime(new Date());
        int res = topicMapper.updateByPrimaryKeySelective(topic);
        if (res==1)
            return new QueryVo(0,topic,"成功");
        else return new QueryVo(605,null,"网络异常");
    }

    @Override
    public QueryVo delete(Topic topic) {
        topic.setUpdateTime(new Date());
        topic.setDeleted(true);
        int res = topicMapper.updateByPrimaryKeySelective(topic);
        if (res==1)
            return new QueryVo(0,topic,"成功");
        else return new QueryVo(605,null,"网络异常");
    }
}
