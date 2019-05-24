package com.cskaoyan.malladmin.service.market;

import com.cskaoyan.malladmin.bean.market.Keywords;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 21:59
 */
public interface KeywordService {
    QueryVo getKeyWordList(QueryIn queryIn, String keyword, String url);

    QueryVo deleteKeyword(Keywords keywords);

    QueryVo updateKeyword(Keywords keywords);

    QueryVo createKeyword(Keywords keywords);
}
