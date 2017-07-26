package com.example.http_manage_biz.holder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.http_manage_biz.vo.DecorationInfo;
import com.example.http_manage_biz.utils.NumberUtils;

/**
 * @version : 1.0
 * @Description : 目前项目图片通用的自定义分割线(仅支持LinearLayout和GridLayoutManager的vertical)
 * @autho : dongyiming
 * @data : 2017/6/7 11:55
 */
public class CommonDecoration extends RecyclerView.ItemDecoration {

    private boolean isHeader;
    private Context mContext;
    private final Paint paint;
    private int colorResource;

    private int leftDividerWidth;
    private int rightDividerWidth;
    private int topDividerWidth;
    private int bottomDividerHeight;

    private int horizontalDividerWidth;
    private int verticalDividerHeight;
    private int verticalDividerMaginLeft;

    public CommonDecoration(Context mContext, DecorationInfo decorationInfo, boolean isHeader) {
        this.mContext = mContext;
        this.isHeader = isHeader;

        this.bottomDividerHeight = decorationInfo.getBottomDividerHeight();
        this.leftDividerWidth = decorationInfo.getLeftDividerWidth();
        this.rightDividerWidth = decorationInfo.getRightDividerWidth();
        this.topDividerWidth = decorationInfo.getTopDividerHeight();

        this.horizontalDividerWidth = decorationInfo.getHorizontalDividerWidth();
        this.verticalDividerHeight = decorationInfo.getVerticalDividerHeight();
        this.verticalDividerMaginLeft = decorationInfo.getVerticalDividerMaginLeft();

        this.colorResource = decorationInfo.getColorResource();

        paint = new Paint();
        paint.setColor(colorResource);

    }

    /**
     * getItemOffsets执行在测量里，会根据Item数多次调用，并且设置的值都会算入child view的padding里，
     * 位置关系：child view --->magin --->divider
     *
     * @param outRect
     * @param itemPosition
     * @param parent
     */
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        if (layoutManager instanceof GridLayoutManager) {

            getGridLayoutItemOffsets(outRect, layoutManager, itemPosition, parent);
        } else if (layoutManager instanceof LinearLayoutManager) {

            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
                getVerticalLinearLayoutItemOffsets(outRect);
            } else {
                getHorizontalLinearLayoutItemOffsets(outRect);
            }
        }
    }

    /**
     * ondraw方法里的位置根据具体业务需求,以及预先设定的magin或者padding来设定着色区域
     * ondraw是绘制在child view的底下
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {

            //绘制水平分割线和竖型分割线
            drawGridHorizontalDivider(c, parent);
            drawGridVerticalDivider(c, parent);

        } else if (layoutManager instanceof LinearLayoutManager) {

            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {

                drawLinearLayoutVertical(c, parent);
            } else {

                drawLinearLayoutHorizontal(c, parent);
            }
        }

    }

    private void getVerticalLinearLayoutItemOffsets(Rect outRect) {

        outRect.set(0, 0, 0, verticalDividerHeight);
    }

    private void getHorizontalLinearLayoutItemOffsets(Rect outRect) {

        outRect.set(0, 0, horizontalDividerWidth, 0);
    }

    /**
     * GridLayout
     *
     * @param outRect
     * @param layoutManager
     * @param itemPosition
     */
    private void getGridLayoutItemOffsets(Rect outRect, RecyclerView.LayoutManager layoutManager, int itemPosition, RecyclerView parent) {

        if (parent != null && parent.getAdapter() != null) {

            GridLayoutManager gridLayout = (GridLayoutManager) layoutManager;
            int spanCount = gridLayout.getSpanCount();
            int childCount = parent.getAdapter().getItemCount();
            int pos = 0;
            if (isHeader) {
                if (itemPosition == 0) {
                    return;
                } else {
                    pos = itemPosition - 1;
                    childCount -= 1;
                }
            }
            if (getFirstLine(pos, spanCount)) {//第一列没有左分割线
                if (getLastRow(childCount, pos, spanCount)) {
                    outRect.set(0, 0, 0, 0);
                } else {
                    outRect.set(0, 0, 0, bottomDividerHeight);
                }
            } else if (getLastRow(childCount, pos, spanCount)) {
                outRect.set(leftDividerWidth, 0, 0, 0);
            } else {
                outRect.set(leftDividerWidth, 0, 0, bottomDividerHeight);
            }
        }
    }

    /**
     * 绘制LinearLayout的Vertical
     *
     * @param c
     * @param parent
     */
    public void drawLinearLayoutVertical(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft() + verticalDividerMaginLeft;
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            if (isHeader && i == 0) {
                continue;
            }
            final View child = parent.getChildAt(i);
            RecyclerView v = new RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + verticalDividerHeight;
            c.drawRect(left, top, right, bottom, paint);
        }
    }

    /**
     * 绘制LinearLayout的Horizontal
     *
     * @param c
     * @param parent
     */
    public void drawLinearLayoutHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isHeader && i == 0) {
                continue;
            }
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + horizontalDividerWidth;
            c.drawRect(left, top, right, bottom, paint);
        }
    }


    /**
     * 绘制grid水平分割线
     *
     * @param c
     * @param parent
     */
    private void drawGridHorizontalDivider(Canvas c, RecyclerView parent) {
        if (parent != null && parent.getAdapter() != null) {

            int itemCount = parent.getAdapter().getItemCount();
            for (int i = 0; i < itemCount; i++) {
                final View childView = parent.getChildAt(i);
                if (childView == null) {
                    continue;
                }
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView
                        .getLayoutParams();

                int left = childView.getLeft() - params.leftMargin;
                int top = childView.getBottom() + params.bottomMargin;
                int right = left + childView.getWidth();
                int bottom = top + bottomDividerHeight;
                c.drawRect(left, top, right, bottom, paint);
            }
        }
    }

    /**
     * grid竖型分割线
     *
     * @param c
     * @param parent
     */
    private void drawGridVerticalDivider(Canvas c, RecyclerView parent) {

        if (parent != null && parent.getAdapter() != null) {

            int itemCount = parent.getAdapter().getItemCount();
            for (int i = 0; i < itemCount; i++) {

                final View childView = parent.getChildAt(i);
                if (childView == null) {
                    continue;
                }
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView
                        .getLayoutParams();
                int right = childView.getLeft() - params.leftMargin;
                int top = childView.getTop() - params.topMargin;
                int bottom = top + childView.getHeight() + params.bottomMargin + bottomDividerHeight;
                int left = right - leftDividerWidth;
                c.drawRect(left, top, right, bottom, paint);
            }
        }
    }

    /**
     * 第一列
     *
     * @param position
     * @param spanCount
     * @return
     */
    public boolean getFirstLine(int position, int spanCount) {

        return position % spanCount == 0 ? true : false;
    }

    /**
     * 最后一列
     *
     * @param position
     * @param spanCount
     * @return
     */
    public boolean getLastLine(int position, int spanCount) {

        return (position + 1) % spanCount == 0 ? true : false;
    }

    /**
     * 第一行
     *
     * @param position
     * @param spanCount
     * @return
     */
    public boolean getFirstRow(int position, int spanCount) {
        return position < spanCount ? true : false;

    }

    /**
     * 最后一行
     *
     * @param count
     * @param position
     * @param spanCount
     * @return
     */
    public boolean getLastRow(int count, int position, int spanCount) {

        int row = NumberUtils.ceilNum(count, spanCount);//总行数
        int totle = row * spanCount;
        return (position + spanCount) >= totle ? true : false;
    }

}
