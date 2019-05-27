package com.cskaoyan.malladmin.mapper.market;

import com.cskaoyan.malladmin.bean.market.Keywords;

import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 22:02
 */
public interface KeywordMapper {
    int queryKeywordListCount(Keywords key);

    List<Keywords> queryKeywordList(Keywords key);

    int deleteKeyword(Keywords keywords);

    int updateKeyword(Keywords keywords);

    int createKeyword(Keywords keywords);

    List<Keywords>  getDefault();

    List<Keywords> getHot();

    List<Keywords> getRandomKeyword(int counts);

    List<String> getKeywordLikeList(String keyword);
}
