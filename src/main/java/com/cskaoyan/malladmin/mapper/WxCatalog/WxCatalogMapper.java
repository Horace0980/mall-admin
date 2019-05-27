package com.cskaoyan.malladmin.mapper.WxCatalog;

import com.cskaoyan.malladmin.bean.wxCategory.WxCategory;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Dankin
 * @Date: 2019/5/27 17:34
 */
public interface WxCatalogMapper {
    List<WxCategory> queryCategoryList(@Param("pid") int pid);
    WxCategory queryCurrentCategory(@Param("id")int id);
    List<WxCategory> querySubCategory(@Param("pid")int pid);
}
