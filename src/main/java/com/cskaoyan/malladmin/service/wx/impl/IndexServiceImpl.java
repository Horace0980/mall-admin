package com.cskaoyan.malladmin.service.wx.impl;

import com.cskaoyan.malladmin.service.wx.IndexService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 16:24
 */
@Service
public class IndexServiceImpl implements IndexService {



    @Override
    public QueryVo wxHome() {
        HashMap<Object, Object> map = new HashMap<>();




        return new QueryVo(0,map,"success");
    }
}
