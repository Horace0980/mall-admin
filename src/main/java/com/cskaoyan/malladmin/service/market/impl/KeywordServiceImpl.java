package com.cskaoyan.malladmin.service.market.impl;

import com.cskaoyan.malladmin.bean.market.Keywords;
import com.cskaoyan.malladmin.mapper.market.KeywordMapper;
import com.cskaoyan.malladmin.service.market.KeywordService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 21:59
 */
@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public QueryVo getKeyWordList(QueryIn queryIn, String keyword, String url) {

        Keywords key = new Keywords();
        if (keyword!=null){
            key.setKeyword("%"+keyword+"%");
        }
        if (url != null){
            key.setUrl("%"+url+"%");
        }


        int total = keywordMapper.queryKeywordListCount(key);

        HashMap<String, Object> map = new HashMap<>();

        map.put("total",total);

        if (total%queryIn.getLimit() == 0){
            map.put("pages",total/queryIn.getLimit());

        }else {
            map.put("pages",total/queryIn.getLimit()+1);

        }

        map.put("page",queryIn.getPage());
        map.put("limit",queryIn.getLimit());


        PageHelper.startPage(queryIn.getPage(),queryIn.getLimit());

        List<Keywords> keywords = keywordMapper.queryKeywordList(key);

        map.put("items",keywords);


        return new QueryVo(0,map,"成功");

    }

    @Override
    public QueryVo deleteKeyword(Keywords keywords) {

        QueryVo queryVo = new QueryVo();

        Date date = new Date();

        keywords.setUpdateTime(date);

        int isDelete =  keywordMapper.deleteKeyword(keywords);

        if (isDelete == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;

    }

    @Override
    public QueryVo updateKeyword(Keywords keywords) {
        QueryVo queryVo = new QueryVo();

        Date date = new Date();

        keywords.setUpdateTime(date);

        int isUpdate = keywordMapper.updateKeyword(keywords);

        if (isUpdate == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;

    }

    @Override
    public QueryVo createKeyword(Keywords keywords) {
        QueryVo queryVo = new QueryVo();
        Date date = new Date();
        keywords.setUpdateTime(date);
        keywords.setAddTime(date);
        int isCreate = keywordMapper.createKeyword(keywords);

        if (isCreate == 1){
            queryVo.setErrmsg("成功");
            queryVo.setErrno(0);
        }else {
            queryVo.setErrmsg("失败");
            queryVo.setErrno(605);
        }

        return queryVo;

    }

    /**
     * 返回defaultKeyword historyKeywordList hotKeywordList
     * @return
     * @param historyKeywordList
     */
    @Override
    public QueryVo getDefaultAndHotKeywords(List<Keywords> historyKeywordList) {
        List<Keywords> keywords = keywordMapper.getDefault();
        List<Keywords> keywords_hot = keywordMapper.getHot();
        //判断size
        if (historyKeywordList==null || historyKeywordList.size()==0){
            historyKeywordList = new ArrayList<>();
        }
        if (keywords.size()==0){
            //随机返回
            keywords = keywordMapper.getRandomKeyword(1);
        }
        if (keywords_hot.size()==0){
            keywords_hot=keywordMapper.getRandomKeyword(3);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("defaultKeyword",keywords.get(0));
        map.put("historyKeywordList",historyKeywordList);
        map.put("hotKeywordList",keywords_hot);

        return new QueryVo(0,map,"成功");


    }

    /**
     * 返回相似于keyword的一个keywordlist，只含有keyword
     * @param keyword
     * @return
     */
    @Override
    public QueryVo getKeywordLikeList(String keyword) {
        List<String> keywords = keywordMapper.getKeywordLikeList("%"+keyword+"%");
        return new QueryVo(0,keywords,"成功");
    }
}
