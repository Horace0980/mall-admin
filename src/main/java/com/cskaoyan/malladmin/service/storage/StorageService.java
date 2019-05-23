package com.cskaoyan.malladmin.service.storage;

import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:14
 */
public interface StorageService {
  QueryVo queryPage(int page,int limit);
}
