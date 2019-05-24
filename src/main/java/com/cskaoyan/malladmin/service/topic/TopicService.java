package com.cskaoyan.malladmin.service.topic;

import com.cskaoyan.malladmin.bean.topic.Topic;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: yyc
 * @Date: 2019/5/23 15:17
 */
public interface TopicService {
    QueryVo getByCondition(QueryIn queryIn, String title, String subtitle);

    QueryVo addNew(Topic topic);

    QueryVo update(Topic topic);

    QueryVo delete(Topic topic);
}
