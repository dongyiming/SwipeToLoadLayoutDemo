package com.example.http_manage_biz.service;


import com.example.http_manage_biz.vo.ncvo.NcMenu;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * @version : 1.0
 * @Description : 歌单接口，通过动态代理加载
 * @autho : dongyiming
 * @data : 2017/7/14 14:47
 */
public interface MenuService {

    /**
     * 为了快速开发，服务器只封装了原始的json数据
     *
     * @return
     */
    @GET("getMenuByType")
    public Observable<List<NcMenu>> getMenuByType(@Query("type") int type, @Query("startIndex") int startIndex, @Query("pageCount") int pageCount);

}
