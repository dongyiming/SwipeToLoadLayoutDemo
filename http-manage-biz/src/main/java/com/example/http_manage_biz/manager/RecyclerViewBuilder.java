package com.example.http_manage_biz.manager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.http_manage_biz.holder.CommonDecoration;
import com.example.http_manage_biz.vo.DecorationInfo;


/**
 * @version : 1.0
 * @Description : 建造者模式来构建RecyclerView
 * @autho : dongyiming
 * @data : 2017/6/8 18:54
 */
public class RecyclerViewBuilder {

    private Context mContext;
    private RecyclerView recyclerView;

    public RecyclerViewBuilder(Context mContext, RecyclerView recyclerView) {

        this.mContext = mContext;
        this.recyclerView = recyclerView;
    }

    /**
     * 配置嵌套的GridLayoutManager
     *
     * @param spanSize
     * @return
     */
    public RecyclerViewBuilder setGridLayoutManager(int spanSize) {

        //解决嵌套卡顿的问题
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, spanSize));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        return this;
    }

    /**
     * 配置常规的GridLayoutManager
     *
     * @param spanSize
     * @return
     */
    public RecyclerViewBuilder setDefultGridLayoutManager(int spanSize) {

        recyclerView.setLayoutManager(new GridLayoutManager(mContext, spanSize));
        return this;
    }

    /**
     * 配置LayoutManager
     *
     * @return
     */
    public RecyclerViewBuilder setLinearLayoutManager() {

        //嵌套卡顿的问题
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        return this;
    }

    /**
     * 设置非嵌套的LinearLayout
     *
     * @return
     */
    public RecyclerViewBuilder setDefaultLinearLayoutManager() {

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        return this;
    }

    /**
     * 配置DecorationInfo
     *
     * @param decorationInfo
     * @return
     */
    public RecyclerViewBuilder setItemDecoration(DecorationInfo decorationInfo, boolean isHeader) {

        CommonDecoration commonDecoration = new CommonDecoration(mContext, decorationInfo, isHeader);
        recyclerView.addItemDecoration(commonDecoration);
        return this;
    }

    public RecyclerView create() {

        return recyclerView;
    }

}
