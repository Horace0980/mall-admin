package com.cskaoyan.malladmin.controller.controller;

import com.cskaoyan.malladmin.service.log.LogService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:53
 */
@RestController
public class LogController {
  @Autowired
  LogService logService;

  @RequestMapping("log/list")
  public QueryVo queryPage(int page,int limit){
    QueryVo queryVo = logService.queryPage(page, limit);
    return queryVo;
  }
}
