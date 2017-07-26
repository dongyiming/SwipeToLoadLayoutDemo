package com.example.http_manage_biz.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @version : 1.0
 * @Description : super viewholer
 * @autho : dongyiming
 * @data : 2017/6/6 1:34
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> widgetViews;
    private View mView;

    public BaseViewHolder(Context mContext, View itemView) {
        super(itemView);
        widgetViews = new SparseArray<>();
        mView = itemView;
    }

    /**
     * 通过layoutId创建viewholder
     *
     * @param mContext
     * @param layoutId
     * @param parent
     * @param convertView
     * @return
     */
    public static BaseViewHolder build(Context mContext, int layoutId, ViewGroup parent, View convertView) {

        View itemView = LayoutInflater.from(mContext).inflate(layoutId, parent,
                false);
        BaseViewHolder holder = new BaseViewHolder(mContext, itemView);
        return holder;
    }

    /**
     * 通过控件的ID获取到Widget
     *
     * @param widgetId
     * @param <T>
     * @return
     */
    public <T extends View> T getWidget(int widgetId) {

        View view;
        if (widgetViews != null) {

            view = widgetViews.get(widgetId);
            if (view == null) {

                view = mView.findViewById(widgetId);
                widgetViews.put(widgetId, view);
            }
        } else {
            view = mView.findViewById(widgetId);
            widgetViews.put(widgetId, view);
        }
        return (T) view;
    }

    /**
     * 填充TextView
     *
     * @param viewId
     * @param text
     * @return
     */
    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = (TextView) getWidget(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * imageview填充
     *
     * @param viewId
     * @param imgResource
     * @return
     */
    public BaseViewHolder setImageView(int viewId, int imgResource) {

        ImageView imageView = (ImageView) getWidget(viewId);
        imageView.setImageResource(imgResource);
        return this;
    }
}
