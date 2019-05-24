package com.cskaoyan.malladmin.controller.storage;

import com.cskaoyan.malladmin.bean.storage.Storage;
import com.cskaoyan.malladmin.service.storage.StorageService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:04
 */
@RestController
@RequestMapping("storage")
public class StorageControler {

  @Autowired
  StorageService storageService;

  //查找操作
  //分页页面
  @RequestMapping("list")
  public QueryVo storagePage(int page,int limit){
    QueryVo queryVo = storageService.queryPage(page, limit);
    return queryVo;
  }

  //更新操作
  @RequestMapping("update")
  public QueryVo updateStroage(@RequestBody Storage storage){
    boolean flag = storageService.updateStorage(storage);
    QueryVo queryVo = new QueryVo();
    if (flag){
      queryVo.setErrmsg("成功");
      queryVo.setErrno(0);
    }else {
      queryVo.setErrmsg("失败！");
      queryVo.setErrno(605);
    }
    return queryVo;
  }

  //删除操作
  @RequestMapping("delete")
  public QueryVo deleteStorage(@RequestBody Storage storage){
    boolean flag = storageService.deleteStorage(storage);
    QueryVo queryVo = new QueryVo();
    if (flag){
      queryVo.setErrmsg("成功");
      queryVo.setErrno(0);
    }else {
      queryVo.setErrmsg("失败！");
      queryVo.setErrno(605);
    }
    return queryVo;
  }
}
