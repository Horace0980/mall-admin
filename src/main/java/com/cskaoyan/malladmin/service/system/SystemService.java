package com.cskaoyan.malladmin.service.system;

import com.cskaoyan.malladmin.bean.system.MallSystem;
import java.util.List;
import java.util.Map;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:01
 */

public interface SystemService {
    List<MallSystem> selectMallSystemByPrefix(String prefix);
    boolean updateMallSystemBykeyName(Map<String, String> systemMap);
}
