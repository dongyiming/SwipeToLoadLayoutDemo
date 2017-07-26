package com.example.http_manage_biz.utils;

/**
 * @version : 1.0
 * @Description : 对数字做处理
 * @autho : dongyiming
 * @data : 2017/7/26 13:15
 */
public class NumberUtils {

    /**
     * 得到两个整数相除后向上取整,保留两位小数可以用float
     *
     * @param a
     * @param b
     * @return
     */
    public static int ceilNum(int a, int b) {

        return (int) Math.ceil((double) a / b);
    }

    /**
     * 整数相除后向下取整
     *
     * @param a
     * @param b
     * @return
     */
    public static int floorNum(int a, int b) {

        return (int) Math.floor((double) a / b);
    }

    /**
     * 四舍五入
     *
     * @param a
     * @param b
     * @return
     */
    public static int roundNum(int a, int b) {

        return (int) Math.round((double) a / b);
    }
}
