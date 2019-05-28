package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 16:55
 */
public interface BrandMapper {
    int queryBrandListCount(String id, String name);

    List<Brand> queryBrandList(String id, String name);

    int deleteBrand(Brand brand);

    int createBrand(Brand brand);

    int updateBrand(Brand brand);

    List<Brand> getBrandList();

    Brand selectBrandById(@Param("id") int id);
}
