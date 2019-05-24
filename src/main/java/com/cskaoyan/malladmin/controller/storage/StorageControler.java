package com.cskaoyan.malladmin.controller.storage;

import com.cskaoyan.malladmin.service.storage.StorageService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:04
 */
@RestController
public class StorageControler {

  @Autowired
  StorageService storageService;

  //分页页面
  @RequestMapping("storage/list")
  public QueryVo storagePage(int page,int limit){
    QueryVo queryVo = storageService.queryPage(page, limit);
    return queryVo;
  }
}
