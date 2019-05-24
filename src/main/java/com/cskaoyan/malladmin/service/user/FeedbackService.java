package com.cskaoyan.malladmin.service.user;

import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
public interface FeedbackService {
    PageHandler selectAllFeedback(QueryIn queryIn, String username, String id);
}
