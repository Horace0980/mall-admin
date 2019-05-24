package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Category;
import com.cskaoyan.malladmin.mapper.market.CategoryMapper;
import com.cskaoyan.malladmin.service.market.CategoryService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public QueryVo deleteCategory(Category category) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        category.setUpdateTime(date);
        int isDelete = categoryMapper.deleteCategory(category);
        if (isDelete == 1){
            queryVo.setErrmsg("success");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrno(605);
            queryVo.setErrmsg("failed");
        }
        return queryVo;
    }

    @Override
    public QueryVo createCategory(Category category) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        category.setUpdateTime(date);
        category.setAddTime(date);
        int isCreate = categoryMapper.createCategory(category);
        if (isCreate ==1){
            queryVo.setErrmsg("success");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrno(605);
            queryVo.setErrmsg("failed");
        }
        return queryVo;
    }

    @Override
    public QueryVo updateCategory(Category category) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        String level = category.getLevel();
        if (level.equals("L1")){
            category.setPid(0);
        }
        category.setUpdateTime(date);
        int isUpdate = categoryMapper.updateCategory(category);

        if (isUpdate ==1){
            queryVo.setErrmsg("success");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrno(605);
            queryVo.setErrmsg("failed");
        }
        return queryVo;
    }
}
