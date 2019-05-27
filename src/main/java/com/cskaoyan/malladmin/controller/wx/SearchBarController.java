package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.bean.market.Keywords;
import com.cskaoyan.malladmin.controller.market.KeywordController;
import com.cskaoyan.malladmin.service.market.KeywordService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/5/27 20:14
 */
@RestController
@RequestMapping("wx/search")
public class SearchBarController {
    @Autowired
    private KeywordService keywordService;

    @RequestMapping("index")
    public QueryVo getDefaultKeywords(HttpSession session){
        List<Keywords> historyKeywordList = (List<Keywords>) session.getAttribute("historyKeywordList");
        return keywordService.getDefaultAndHotKeywords(historyKeywordList);
    }
    @RequestMapping("helper")
    public QueryVo getSearchReminder(String keyword){
        return keywordService.getKeywordLikeList(keyword);
    }



}
