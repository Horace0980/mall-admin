package com.cskaoyan.malladmin.controller.wx;

import com.cskaoyan.malladmin.config.PhoneCode;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Qiu
 * @Date: 2019/5/28 16:39
 */
@RestController
@RequestMapping("wx/auth")
public class WxAuthController {

    @RequestMapping(value = "regCaptcha",method = {RequestMethod.POST,RequestMethod.GET})
    public QueryVo regCaptcha(@RequestBody String mobile, HttpServletRequest request){

        QueryVo queryVo = new QueryVo();
        String phoneMsg = PhoneCode.getPhoneMsg(mobile, request);

        if (!phoneMsg.equals("true")){
            queryVo.setErrno(605);
        }else {
            queryVo.setErrno(0);
        }

        queryVo.setErrmsg(phoneMsg);
        return queryVo;

    }

}
