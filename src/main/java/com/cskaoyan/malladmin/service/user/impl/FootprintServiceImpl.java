package com.cskaoyan.malladmin.service.user.impl;

import com.cskaoyan.malladmin.bean.user.Footprint;
import com.cskaoyan.malladmin.mapper.user.FootprintMapper;
import com.cskaoyan.malladmin.mapper.user.UserMapper;
import com.cskaoyan.malladmin.service.user.FootprintService;
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
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;


    @Override
    public PageHandler selectAllFootprint(QueryIn queryIn ,String goodsId,String userId){
        int gi=goodsId!=null? Integer.parseInt(goodsId):0;
        int ui=goodsId!=null? Integer.parseInt(userId):0;

        int total=footprintMapper.queryFootprintCount(gi,ui);
        PageHandler pageHandler=new PageHandler();
        pageHandler.setTotal(total);

        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Footprint> list=footprintMapper.selectAllFootprint
                (queryIn.getSort(),queryIn.getOrder(),gi,ui);

        //list=getList(list);
        pageHandler.setItems(list);

        return pageHandler;
    }


}
