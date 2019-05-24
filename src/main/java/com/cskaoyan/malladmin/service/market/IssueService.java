package com.cskaoyan.malladmin.service.market;

import com.cskaoyan.malladmin.bean.market.Issue;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:07
 */
public interface IssueService {
    QueryVo getIssueList(QueryIn queryIn, String question);

    QueryVo deleteIssue(Issue issue);

    QueryVo updateIssue(Issue issue);

    QueryVo createIssue(Issue issue);
}
