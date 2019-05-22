package com.cskaoyan.malladmin.service.ad.impl;

import com.cskaoyan.malladmin.bean.ad.Ad;
import com.cskaoyan.malladmin.bean.ad.AdExample;
import com.cskaoyan.malladmin.mapper.ad.AdMapper;
import com.cskaoyan.malladmin.service.ad.AdService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/22 20:01
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;
    @Override
    public QueryVo queryConditions(QueryIn queryIn, String name, String content) {
        AdExample adExample = new AdExample();
        AdExample.Criteria or = adExample.or();
        if (content!=null&& content.trim().length()>0){
            or.andContentLike("%"+content+"%");
        }
        if (name!=null && name.trim().length()>0){
            or.andNameLike("%"+name+"%");
        }
        long l = adMapper.countByExample(adExample);
        adExample.setOrderByClause(queryIn.getSort()+" "+queryIn.getOrder());
        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());
        List<Ad> ads = adMapper.selectByExample(adExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",ads);
        map.put("total",l);
        return new QueryVo(0,map,"成功");

    }

    @Override
    public QueryVo addNew(Ad ad) {
        Date date = new Date();
        ad.setAddTime(date);
        ad.setUpdateTime(date);
        int i = adMapper.insertSelective(ad);
        if (i!=1)
            return new QueryVo(605,null,"插入失败！网络异常！");

        return new QueryVo(0,ad,"成功");
    }

    @Override
    public QueryVo updateById(Ad ad) {
        Date date = new Date();
        ad.setUpdateTime(date);
        int update = adMapper.updateByPrimaryKeySelective(ad);
        if (update!=1){
            return new QueryVo(605,null,"更新失败！网络异常！");
        }
        return new QueryVo(0,ad,"成功");
    }

    @Override
    public QueryVo deleteById(Ad ad) {
        int i = adMapper.updateDeletedById(true,ad.getId());
        if (i!=1){
            return new QueryVo(605,null,"更新失败！网络异常！");
        }
        return new QueryVo(0,null,"成功");
    }
}
