package com.example.http_manage_biz.vo;

/**
 * @version : 1.0
 * @Description : 自定义分割线的数据
 * @autho : dongyiming
 * @data : 2017/6/8 16:46
 */
public class DecorationInfo {

    //gridview的分割线的自定义宽高
    private int bottomDividerHeight;
    private int topDividerHeight;
    private int leftDividerWidth;
    private int rightDividerWidth;

    //linearlayout的自定义宽高
    private int horizontalDividerWidth;
    private int verticalDividerHeight;
    private int verticalDividerMaginLeft;

    private int colorResource;

    public int getHorizontalDividerWidth() {
        return horizontalDividerWidth;
    }

    public int getVerticalDividerMaginLeft() {
        return verticalDividerMaginLeft;
    }

    public DecorationInfo setVerticalDividerMaginLeft(int verticalDividerMaginLeft) {
        this.verticalDividerMaginLeft = verticalDividerMaginLeft;
        return this;
    }

    public DecorationInfo setHorizontalDividerWidth(int horizontalDividerWidth) {
        this.horizontalDividerWidth = horizontalDividerWidth;
        return this;
    }

    public int getVerticalDividerHeight() {
        return verticalDividerHeight;
    }

    public DecorationInfo setVerticalDividerHeight(int verticalDividerHeight) {
        this.verticalDividerHeight = verticalDividerHeight;
        return this;
    }

    public int getBottomDividerHeight() {
        return bottomDividerHeight;
    }

    public DecorationInfo setBottomDividerHeight(int bottomDividerHeight) {
        this.bottomDividerHeight = bottomDividerHeight;
        return this;
    }

    public int getTopDividerHeight() {
        return topDividerHeight;
    }

    public DecorationInfo setTopDividerHeight(int topDividerHeight) {
        this.topDividerHeight = topDividerHeight;
        return this;
    }

    public int getLeftDividerWidth() {
        return leftDividerWidth;
    }

    public DecorationInfo setLeftDividerWidth(int leftDividerWidth) {
        this.leftDividerWidth = leftDividerWidth;
        return this;
    }

    public int getRightDividerWidth() {
        return rightDividerWidth;
    }

    public DecorationInfo setRightDividerWidth(int rightDividerWidth) {
        this.rightDividerWidth = rightDividerWidth;
        return this;
    }

    public int getColorResource() {
        return colorResource;
    }

    public DecorationInfo setColorResource(int colorResource) {
        this.colorResource = colorResource;
        return this;
    }

    @Override
    public String toString() {
        return "DecorationInfo{" +
                "colorResource=" + colorResource +
                ", verticalDividerMaginLeft=" + verticalDividerMaginLeft +
                ", verticalDividerHeight=" + verticalDividerHeight +
                ", horizontalDividerWidth=" + horizontalDividerWidth +
                ", rightDividerWidth=" + rightDividerWidth +
                ", leftDividerWidth=" + leftDividerWidth +
                ", topDividerHeight=" + topDividerHeight +
                ", bottomDividerHeight=" + bottomDividerHeight +
                '}';
    }
}
