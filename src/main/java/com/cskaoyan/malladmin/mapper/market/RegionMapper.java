package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Region;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 23:46
 */
public interface RegionMapper {



    int queryProvinceCount();

    List<Region> queryProvince();

    List<Region> queryCity(String code);

    List<Region> queryDistrict(String code);
}
