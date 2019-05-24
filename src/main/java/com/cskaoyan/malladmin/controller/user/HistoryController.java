package com.cskaoyan.malladmin.controller.user;

import com.cskaoyan.malladmin.service.user.HistoryService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:12
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @RequestMapping("/list")
    public QueryVo selectAllHistory(QueryIn queryIn,String keyword,String userId){
        PageHandler pageHandler=null;
        pageHandler= historyService.selectAllHistory(queryIn,keyword,userId);

        return new QueryVo(0,pageHandler,"成功");
    }

}
