package com.cskaoyan.malladmin.controller.market;

import com.cskaoyan.malladmin.bean.market.Keywords;
import com.cskaoyan.malladmin.service.market.KeywordService;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;

/**
 * @Author: Qiu
 * @Date: 2019/5/22 21:58
 */


@RestController
@RequestMapping("keyword")
public class KeywordController {

    @Autowired
    KeywordService keywordService;


    @RequestMapping("list")
    public QueryVo getKeyWordList(QueryIn queryIn, String keyword, String url){
        QueryVo keyWordList = keywordService.getKeyWordList(queryIn,keyword,url);
        return keyWordList;
    }

    @RequestMapping("delete")
    public QueryVo deleteKeyword(@RequestBody Keywords keywords){

        QueryVo deleteKeyword = keywordService.deleteKeyword(keywords);

        return deleteKeyword;
    }

    @RequestMapping("update")
    public QueryVo updateKeyword(@RequestBody Keywords keywords){
        QueryVo updateKeyword = keywordService.updateKeyword(keywords);

        return updateKeyword;
    }

    @RequestMapping("create")
    public QueryVo createKeyword(@RequestBody Keywords keywords){
        QueryVo createKeyword = keywordService.createKeyword(keywords);
        return createKeyword;
    }



}
