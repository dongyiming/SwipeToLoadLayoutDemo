package com.example.sr_layout_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;

/**
 * @version : 1.0
 * @Description : 自定义头部，随便弄弄，主要是上拉加载
 * @autho : dongyiming
 * @data : 2017/7/26 15:50
 */
public class RefreshHeader extends TextView implements SwipeRefreshTrigger, SwipeTrigger {

    public RefreshHeader(Context context) {
        super(context);
    }

    public RefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onRefresh() {
        setText("REFRESHING");
    }

    @Override
    public void onPrepare() {
        setText("");
    }

    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {
        if (!isComplete) {
            if (yScrolled >= getHeight()) {
                setText("RELEASE TO REFRESH");
            } else {
                setText("SWIPE TO REFRESH");
            }
        } else {
            setText("REFRESH RETURNING");
        }
    }

    @Override
    public void onRelease() {
    }

    @Override
    public void onComplete() {
        setText("COMPLETE");
    }

    @Override
    public void onReset() {
        setText("");
    }
}
