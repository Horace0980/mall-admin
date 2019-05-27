package com.cskaoyan.malladmin.service.wx;

import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 21:59
 */
public interface WxTopicService {
    QueryVo detail(String id);

    QueryVo related(String id);
}
