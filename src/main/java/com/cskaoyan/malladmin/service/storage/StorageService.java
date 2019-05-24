package com.cskaoyan.malladmin.service.storage;

import com.cskaoyan.malladmin.bean.Image;
import com.cskaoyan.malladmin.bean.storage.Storage;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:14
 */
public interface StorageService {
  QueryVo queryPage(int page,int limit);

  boolean insertStorage(Storage storage);

  boolean updateStorage(Storage storage);

  boolean deleteStorage(Storage storage);
}
