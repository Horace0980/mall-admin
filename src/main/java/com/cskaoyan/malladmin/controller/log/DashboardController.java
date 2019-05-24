package com.cskaoyan.malladmin.controller.log;

import com.cskaoyan.malladmin.service.log.DashboardService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/24 16:15
 */
@RestController
public class DashboardController {
  @Autowired
  DashboardService dashboardService;

  @RequestMapping("dashboard")
  public QueryVo dashboard(){
    return dashboardService.dashboard();
  }

}
