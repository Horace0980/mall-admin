package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.bean.market.Issue;
import com.cskaoyan.malladmin.service.market.IssueService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:04
 */

@RestController
@RequestMapping("issue")
public class IssueController {


    @Autowired
    IssueService issueService;

    @RequestMapping("list")
    public QueryVo getIssueList(QueryIn queryIn,String question){

        return issueService.getIssueList(queryIn,question);
    }

    @RequestMapping("create")
    public QueryVo createIssue(@RequestBody Issue issue){
        QueryVo createIssue = issueService.createIssue(issue);
        return createIssue;
    }
    @RequestMapping("update")
    public QueryVo updateIssue(@RequestBody Issue issue){
        QueryVo updateIssue = issueService.updateIssue(issue);
        return updateIssue;
    }
    @RequestMapping("delete")
    public QueryVo deleteIssue(@RequestBody Issue issue){
        QueryVo deleteIssue = issueService.deleteIssue(issue);
        return deleteIssue;
    }

}
