package com.cskaoyan.malladmin.utils;

import java.io.File;

/**
 * @Author: Qiu
 * @Date: 2019/5/23 21:10
 */
public class UploadUtils {

    public final static String IMG_PATH_PREFIX = "static/img";

    public static File getImgDirFile(){
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);

        File file = new File(fileDirPath);
        if (!file.exists()){
            file.mkdirs();
        }

        return file;
    }

}
