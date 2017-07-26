package com.example.http_manage_biz.http;


import com.example.http_manage_biz.funaction.MenuInfoFun;
import com.example.http_manage_biz.manager.RetrofitBuilder;
import com.example.http_manage_biz.service.MenuService;
import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * @version : 1.0
 * @Description : 歌单的所有网络操作
 * @autho : dongyiming
 * @data : 2017/7/14 15:03
 */
public class MenuInfoHttpInvoker implements IMenuInfoHttpInvoker {

    private MenuService menuService;

    public MenuInfoHttpInvoker() {

        Retrofit retrofit = RetrofitBuilder.getInstance().getRetrofit();
        menuService = retrofit.create(MenuService.class);
    }

    /**
     * 获取所有歌单数据
     *
     * @param subscriber
     */
    @Override
    public void getMenuByType(int type, int startIndex, int pageCount, ResourceObserver<List<MenuInfo>> subscriber) {

        menuService.getMenuByType(type, startIndex, pageCount)
                .map(new MenuInfoFun())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
