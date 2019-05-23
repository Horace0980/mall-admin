package com.cskaoyan.malladmin.bean.user;

/**
 * @Author: xf
 * @Date: 2019/5/23 15:16
 */
public class UserPage {

    public static int getStart(int page,int limit,int total){
        int start=(page-1)*limit;
        if(start >= total){
            start= (total%limit==0?total/limit-1:total/limit)*limit;
        }
        return start;
    }
}
