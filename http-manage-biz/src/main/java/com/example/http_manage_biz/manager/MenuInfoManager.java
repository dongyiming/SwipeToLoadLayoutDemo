package com.example.http_manage_biz.manager;


import android.util.Log;

import com.example.http_manage_biz.http.IMenuInfoHttpInvoker;
import com.example.http_manage_biz.http.MenuInfoHttpInvoker;
import com.example.http_manage_biz.interaction.ICommonInvokeResult;
import com.example.http_manage_biz.repository.IMenuRepository;
import com.example.http_manage_biz.repository.MenuRepository;
import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.ResourceObserver;


/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/14 14:53
 */
public class MenuInfoManager {

    private final IMenuInfoHttpInvoker menuInfoHttpInvoker;
    private final IMenuRepository menuRepository;

    public MenuInfoManager() {

        menuInfoHttpInvoker = new MenuInfoHttpInvoker();
        menuRepository = new MenuRepository();
    }

    /**
     * @param type
     * @param startIndex
     * @param pageCount
     * @return
     */
    public void selectByType(int type, int startIndex, int pageCount, final ICommonInvokeResult<List<MenuInfo>, String> commonInvokeResult) {

        ResourceObserver<List<MenuInfo>> resourceObserver = new ResourceObserver<List<MenuInfo>>() {
            @Override
            public void onNext(@NonNull List<MenuInfo> menuInfos) {

                for (MenuInfo menuInfo : menuInfos) {

                    Log.e("dongyiming", "onNext: " + menuInfo.getMenuName());
                }
                menuRepository.insertList(menuInfos);
                commonInvokeResult.OnResult(menuInfos);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                commonInvokeResult.onFailure(e.toString());
            }

            @Override
            public void onComplete() {

                commonInvokeResult.onCompleted();
            }
        };
        menuInfoHttpInvoker.getMenuByType(type, startIndex, pageCount, resourceObserver);
    }

}
