package com.example.sr_layout_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeLoadMoreTrigger;
import com.aspsine.swipetoloadlayout.SwipeTrigger;
import com.example.sr_layout_ui.R;

/**
 * @version : 1.0
 * @Description : 自定义加载更多：界面调试极其恶心，弄了一下午，textview不忘记设置hint
 * @autho : dongyiming
 * @data : 2017/7/25 23:48
 */
public class LoadMoreFooter extends RelativeLayout implements SwipeLoadMoreTrigger, SwipeTrigger {

    private View mView;
    private ImageView loadingView;
    private TextView content;
    private Context mContext;

    public LoadMoreFooter(Context mContext) {
        this(mContext, null);
    }

    public LoadMoreFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreFooter(Context mContext, AttributeSet attrs, int defStyleAttr) {
        super(mContext, attrs, defStyleAttr);
        this.mContext = mContext;
        initView();
    }

    private void initView() {

        mView = LayoutInflater.from(getContext()).inflate(R.layout.activity_footer_layout, null);
        loadingView = (ImageView) mView.findViewById(R.id.image_loading);
        content = (TextView) mView.findViewById(R.id.txt_content);
        addView(mView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    @Override
    public void onLoadMore() {
        loadingView.setVisibility(View.VISIBLE);
        content.setVisibility(View.VISIBLE);
        content.setText(mContext.getString(R.string.string_loading));
    }

    /**
     * onMove之前触发，第一个触发的方法
     */
    @Override
    public void onPrepare() {
    }

    /**
     * 滑动RecyclerView就会触发，一直打印
     * <p>
     * getHeight()为我们设置的下拉的高度
     * yScrolled为偏移Y轴的值，初始为0，后面为负值增大
     *
     * @param yScrolled
     * @param isComplete
     * @param automatic
     */
    @Override
    public void onMove(int yScrolled, boolean isComplete, boolean automatic) {

        loadingView.setVisibility(View.GONE);
        if (!isComplete) {
            if (yScrolled <= -getHeight()) {
                content.setText(mContext.getString(R.string.string_drop));
            } else {
                //最开始触发
                content.setText(mContext.getString(R.string.string_pull));
            }
        } else {
            //最后触发，上拉加载complete后触发
        }

    }

    /**
     * onLoadMore之前触发,刷新成功
     */
    @Override
    public void onRelease() {

        Log.e("dongyiming", "onRelease");
    }

    /**
     * onLoadMore之后，加载完成，释放刷新
     */
    @Override
    public void onComplete() {
        Log.e("dongyiming", "onComplete");
    }

    /**
     * 最后一个触发
     */
    @Override
    public void onReset() {
        Log.e("dongyiming", "onReset");
    }
}
