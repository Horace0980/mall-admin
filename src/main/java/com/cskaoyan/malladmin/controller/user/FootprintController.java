package com.cskaoyan.malladmin.controller.user;

import com.cskaoyan.malladmin.service.user.CollectService;
import com.cskaoyan.malladmin.service.user.FootprintService;
import com.cskaoyan.malladmin.vo.PageHandler;
import com.cskaoyan.malladmin.vo.QueryIn;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xf
 * @Date: 2019/5/22 21:12
 */
@RestController
@RequestMapping("/footprint")
public class FootprintController {
    @Autowired
    FootprintService footprintService;

    @RequestMapping("/list")
    public QueryVo selectAllFootprint(QueryIn queryIn,String valueId,String userId){
        PageHandler pageHandler=null;
        pageHandler= footprintService.selectAllFootprint(queryIn,valueId,userId);

        return new QueryVo(0,pageHandler,"成功");
    }

}
