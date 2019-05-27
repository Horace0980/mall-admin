package com.cskaoyan.malladmin.controller;

import com.cskaoyan.malladmin.bean.Image;
import com.cskaoyan.malladmin.utils.UploadUtils;
import com.cskaoyan.malladmin.vo.QueryVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 21:22
 */
@RequestMapping("admin/storage")
@RestController
public class UploadController {

    @RequestMapping("create")
    public QueryVo uploadPic(@RequestParam("file") MultipartFile file) {

        QueryVo queryVo = new QueryVo();
        try {
            String type = file.getContentType();
            long size = file.getSize();
            String name = file.getOriginalFilename();
            Date date = new Date();
            String key = file.getName();
            String url = InetAddress.getLocalHost().getHostAddress() + "/admin/img/" + name;


            File dirFile = UploadUtils.getImgDirFile();


            File newFile = new File(dirFile.getAbsoluteFile() + File.separator + name);
            file.transferTo(newFile);


            Image image = new Image(1, key, name, (int) size, type, date, date, url);
            queryVo.setData(image);
            queryVo.setErrno(0);
            queryVo.setErrmsg("success");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return queryVo;
    }
}
