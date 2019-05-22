package com.cskaoyan.malladmin.service.system;

import com.cskaoyan.malladmin.bean.system.MallSystem;
import java.util.List;

/**
 * @Author:ZCH
 * @Date:2019/5/22 23:01
 */

public interface SystemService {
    List<MallSystem> selectMallConfigByPrefix(String prefix);
}
