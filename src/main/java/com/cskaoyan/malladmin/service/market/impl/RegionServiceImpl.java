package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Region;

import com.cskaoyan.malladmin.mapper.market.RegionMapper;
import com.cskaoyan.malladmin.service.market.RegionService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<Region> provinces = regionMapper.queryProvince();
        for (int i = 0; i < provinces.size(); i++) {
            Region province = provinces.get(i);
            int code = province.getCode();
            province.setCode(code*10000);

            List<Region> cities = regionMapper.queryCity(code+"%");

            for (int j = 0; j < cities.size(); j++) {
                Region city = cities.get(j);
                int code1 = city.getCode();
                city.setCode(code1*100);
                List<Region> districts = regionMapper.queryDistrict(code1+"%");
                city.setChildren(districts);
            }
            province.setChildren(cities);
        }




        return new QueryVo(0,provinces,"成功");
    }
}
