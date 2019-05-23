package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.Collect;
import com.cskaoyan.malladmin.bean.user.User;
import com.cskaoyan.malladmin.bean.user.UserPage;
import com.cskaoyan.malladmin.mapper.user.CollectMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.CollectService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:14
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;


    @Override
    public PageHandler selectAllCollect(QueryIn queryIn ,String valueId,String userId){
        int vi=valueId!=null? Integer.parseInt(valueId):0;
        int ui=userId!=null? Integer.parseInt(userId):0;
        int total=collectMapper.queryCollectCount(vi,ui);
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());

        List<Collect> list=collectMapper.selectAllCollect
                (queryIn.getSort(),queryIn.getOrder(),vi,ui);

        pageHandler.setItems(list);

        return pageHandler;
    }


}
