package com.example.http_manage_biz.application;

import android.app.Application;
import android.content.Context;

/**
 *  @Description :
 *  @autho : dongyiming
 *  @version : 1.0
 *  @data : 2017/7/10 1:39
 */
public class MyApplication extends Application{

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }

    public static Context getContext() {

        return mContext;
    }
}
