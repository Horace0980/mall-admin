package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Region;

import com.cskaoyan.malladmin.mapper.market.RegionMapper;
import com.cskaoyan.malladmin.service.market.RegionService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:45
 */
@Service
public class RegionServiceImpl implements RegionService {


    @Autowired
    RegionMapper regionMapper;




    @Override
    public QueryVo getRegionList() {

        List<Region> provinces = regionMapper.getProvince();
        List<Region> cities = regionMapper.getCity();
        List<Region> districts = regionMapper.getDistrict();

       cities = getChildren(cities, districts);

       provinces = getChildren(provinces, cities);


      return new QueryVo(0,provinces,"成功");
    }

  private List<Region> getChildren(List<Region> fathers, List<Region> childs) {
    for (Region father : fathers) {
      List<Region> children = new ArrayList<>();
      String cCode = String.valueOf(father.getCode());
      for (Region district : childs) {
        String code = String.valueOf(district.getCode());
        if (cCode.equals(code.substring(0, cCode.length()))) {
          children.add(district);
        }
      }
      father.setChildren(children);
    }

    return fathers;
  }
}
