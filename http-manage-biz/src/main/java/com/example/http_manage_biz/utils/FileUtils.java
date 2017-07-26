package com.example.http_manage_biz.utils;


import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * @version : 1.0
 * @Description : 文件工具类
 * @autho : dongyiming
 * @data : 2017/7/13 1:12
 */
public class FileUtils {


    /**
     * 创建存储目录
     *
     * @param dir
     * @param name
     * @return
     */
    public static File buildDataBasePath(String dir, String name) {

        boolean sdExist = android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
        if (!sdExist) {
            return null;
        } else {
            String dbDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
            String dbPath = dbDir + "/" + dir;// 数据库路径
            File dirFile = new File(dbPath);
            if (!dirFile.exists())
                dirFile.mkdirs();

            boolean isFileCreateSuccess = false;
            // 判断文件是否存在，不存在则创建该文件
            String filePath = dbPath + "/" + name;
            File dbFile = new File(filePath);
            if (!dbFile.exists()) {
                try {
                    isFileCreateSuccess = dbFile.createNewFile();// 创建文件
                    Log.e("dongyiming", "db file create success .{}" + filePath);
                } catch (IOException e) {
                    Log.e("dongyiming", "db file create failed .{} " + e.toString());
                    e.printStackTrace();
                }
            } else {
                isFileCreateSuccess = true;
            }
            if (isFileCreateSuccess)
                return dbFile;
            else
                return null;
        }
    }
}
