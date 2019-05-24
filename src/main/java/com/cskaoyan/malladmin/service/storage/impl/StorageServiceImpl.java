package com.cskaoyan.malladmin.service.storage.impl;

import com.cskaoyan.malladmin.bean.Image;
import com.cskaoyan.malladmin.bean.storage.Storage;
import com.cskaoyan.malladmin.bean.storage.StroageData;
import com.cskaoyan.malladmin.mapper.storage.StorageMapper;
import com.cskaoyan.malladmin.service.storage.StorageService;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:15
 */
@Service
public class StorageServiceImpl implements StorageService {

  @Autowired
  StorageMapper storageMapper;

  @Override
  public QueryVo queryPage(int page,int limit) {
    List<Storage> storages = storageMapper.queryList();
    PageHelper.startPage(page,limit);
    QueryVo queryVo = new QueryVo();

    StroageData stroageData = new StroageData();
    stroageData.setItems(storages);
    stroageData.setTotal(storages.size());

    queryVo.setData(stroageData);
    queryVo.setErrmsg("成功");
    queryVo.setErrno(0);
    return queryVo;
  }

  @Override
  public boolean insertStorage(Storage storage) {
    int insert = storageMapper.insertStorage(storage);
    return insert == 1;
  }
}
