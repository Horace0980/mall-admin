package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Issue;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:09
 */
public interface IssueMapper {
    int queryIssueListCount(Issue issue);

    List<Issue> queryIssueList(Issue issue);

    int deleteIssue(Issue issue);

    int createIssue(Issue issue);

    int updateIssue(Issue issue);
}
