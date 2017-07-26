package com.example.http_manage_biz.http;


import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

import io.reactivex.observers.ResourceObserver;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/14 15:13
 */
public interface IMenuInfoHttpInvoker {
    void getMenuByType(int type, int startIndex, int pageCount, ResourceObserver<List<MenuInfo>> subscriber);
}
