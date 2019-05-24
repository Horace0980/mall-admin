package com.cskaoyan.malladmin.service.log.impl;

import com.cskaoyan.malladmin.bean.log.Log;
import com.cskaoyan.malladmin.bean.log.LogData;
import com.cskaoyan.malladmin.mapper.log.LogMapper;
import com.cskaoyan.malladmin.service.log.LogService;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:57
 */
@Service
public class LogServiceImpl implements LogService {

  @Autowired
  LogMapper logMapper;

  @Override
  public QueryVo queryPage(int page, int limit) {

    List<Log> logs = logMapper.queryList();
    PageHelper.startPage(page,limit);
    QueryVo queryVo = new QueryVo();
    LogData logData = new LogData();


    logData.setItems(logs);
    logData.setTotal(logs.size());

    queryVo.setErrno(0);
    queryVo.setErrmsg("成功");
    queryVo.setData(logData);

    return queryVo;
  }
}
