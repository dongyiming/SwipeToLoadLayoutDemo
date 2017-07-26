package com.example.sr_layout_ui.controller;

import android.content.Context;

import com.example.http_manage_biz.interaction.ICommonInvokeResult;
import com.example.http_manage_biz.manager.MenuInfoManager;
import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/25 16:45
 */
public class SwipeRefreshController {

    private Context mContext;
    private final MenuInfoManager menuInfoManager;

    public SwipeRefreshController(Context mContext) {

        menuInfoManager = new MenuInfoManager();
    }

    public void selectByType(int type, int startIndex, int pageCount, final ICommonInvokeResult<List<MenuInfo>, String> commonInvokeResult) {

        menuInfoManager.selectByType(type, startIndex, pageCount, commonInvokeResult);
    }
}
