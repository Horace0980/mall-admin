package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.service.market.CategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 22:25
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public QueryVo getLevelOne() {

        List<Map> list = new ArrayList<>();

        int pid = 0;

        List<Category> l1 = categoryMapper.getList(pid);

        for (Category c : l1) {
            HashMap hashMap = new HashMap();
            int id = c.getId();
            String name = c.getName();
            hashMap.put("value",id);
            hashMap.put("label",name);
            list.add(hashMap);
        }

        return new QueryVo(0,list,"success");
    }

    @Override
    public QueryVo queryCategoryList() {
        List<Category> l1 = categoryMapper.getList(0);
        for (Category c : l1){
            int id = c.getId();
            List<Category> list = categoryMapper.getList(id);
            c.setChildren(list);
        }

        return new QueryVo(0,l1,"success");

    }
}
