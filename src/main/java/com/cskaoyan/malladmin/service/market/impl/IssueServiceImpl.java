package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Issue;
import com.cskaoyan.malladmin.mapper.market.IssueMapper;
import com.cskaoyan.malladmin.service.market.IssueService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:08
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueMapper issueMapper;

    @Override
    public QueryVo getIssueList(QueryIn queryIn, String question) {

        HashMap<String, Object> map = new HashMap<>();
        Issue issue = new Issue();

        if (question != null){
            issue.setQuestion("%"+question+"%");
        }

        int total = issueMapper.queryIssueListCount(issue);
        map.put("total",total);


        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());

        List<Issue> issueList = issueMapper.queryIssueList(issue);

        map.put("items",issueList);

        return new QueryVo(0,map,"成功");
    }

    @Override
    public QueryVo deleteIssue(Issue issue) {
        QueryVo queryVo = new QueryVo();

        Date date = new Date();
        issue.setUpdateTime(date);

        int isDelete = issueMapper.deleteIssue(issue);

        if (isDelete == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;
    }

    @Override
    public QueryVo updateIssue(Issue issue) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        issue.setUpdateTime(date);
        int isUpdate = issueMapper.updateIssue(issue);

        if (isUpdate == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;
    }

    @Override
    public QueryVo createIssue(Issue issue) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        issue.setUpdateTime(date);
        issue.setAddTime(date);
        int isCreate = issueMapper.createIssue(issue);

        if (isCreate == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;
    }
}
