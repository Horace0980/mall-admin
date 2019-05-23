package com.cskaoyan.malladmin.service.log;

import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.stereotype.Service;

/**
 * @Author: Dankin
 * @Date: 2019/5/23 17:57
 */
public interface LogService {
  public QueryVo queryPage(int page,int limit);
}
