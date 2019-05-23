package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.History;
import com.cskaoyan.malladmin.mapper.user.HistoryMapper;
import com.cskaoyan.malladmin.service.user.HistoryService;
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
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;
    

    @Override
    public PageHandler selectAllHistory(QueryIn queryIn ,String keyword,String userId){
        String  keyword1 = keyword!=null? "%"+keyword+"%":keyword;
        int ui=userId!=null? Integer.parseInt(userId):0;

        int total=historyMapper.queryHistoryCount(keyword1,ui);
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<History> list=historyMapper.selectAllHistory
                (queryIn.getSort(),queryIn.getOrder(),keyword1,ui);

        //list=getList(list);
        pageHandler.setItems(list);

        return pageHandler;
    }


}
