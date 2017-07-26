package com.example.http_manage_biz.interaction;


import com.example.http_manage_biz.holder.BaseViewHolder;

/**
 * @version : 1.0
 * @Description : 普通抽取的多样式adapter接口
 * @autho : dongyiming
 * @data : 2017/6/7 0:53
 */
public interface ICommonRecyclerListener<T> {

    /**
     * 返回类型对应的布局
     *
     * @param type
     * @return
     */
    public int getLayoutId(int type);

    /**
     * 返回当前位置的布局类型
     *
     * @param position
     * @return
     */
    public int getItemViewType(int position);


    /**
     *  holder数据处理
     *
     * @param holder
     * @param t
     * @param position
     * @param type
     */
    public void convert(BaseViewHolder holder, T t, int position, int type);

    /**
     * 绑定的layoutManager设置
     *
     * @param position
     * @param viewType
     * @return
     */
    public int setSpanCount(int position, int viewType);
}
