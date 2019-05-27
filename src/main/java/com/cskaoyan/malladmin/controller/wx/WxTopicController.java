package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.service.wx.WxTopicService;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Qiu
 * @Date: 2019/5/27 21:58
 */
@RestController
@RequestMapping("wx/topic")
public class WxTopicController {

    @Autowired
    WxTopicService wxTopicService;

    @RequestMapping("detail")
    public QueryVo detail(String id){

        QueryVo detail = wxTopicService.detail(id);
        return detail;
    }
    @RequestMapping("related")
    public QueryVo related(String id){
        QueryVo related = wxTopicService.related(id);
        return related;
    }

}
