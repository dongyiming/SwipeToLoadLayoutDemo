package com.example.http_manage_biz.interaction;

/**
 * @version : 1.0
 * @Description : Invoke网络请求的统一结果集
 * @autho : dongyiming
 * @data : 2017/7/14 15:18
 */
public interface ICommonInvokeResult<T, E> {

    void OnResult(T var1);

    void onFailure(E var1);

    void onCompleted();
}
