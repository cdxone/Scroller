package com.cdx.example.scroller.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * 问题：为什么要继承LinearLayout?
 * 其实，继承于LinearLayout或者RelativeLayout都是可以的，只要是继承于容器就可以，因为我们要在其中放入一个控件，来移动它。
 * 因为底层执行的是scrollTo,scrollTo是对"内容"的移动，不是对本身的移动。
 *
 * 这个问题，我错了将近有2个小时，第一次一个小时，第二天又犯了这样的错误，又一个小时，所以一定要牢牢记住，
 * 不要再同一个香蕉皮上摔倒两次。
 */
public class MyView extends LinearLayout {

    private static final String TAG = MyView.class.getSimpleName();
    private Context mContext;
    private Scroller mScroller;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mScroller = new Scroller(mContext);
    }

    /**
     * 缓慢滑动到指定位置
     *
     * @param destX 水平方向滑动的距离，负值表示向右移动，正值表示向左移动。
     * @param destY 竖直方向滑动的距离，负值表示下移动，正值表示向上移动。
     */
    public void smoothScrollTo(int destX, int destY) {
        //1、距离上边界的位置 + 距离左边界的位置
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        Log.e(TAG, "scrollX:" + scrollX + "scrollY:" + scrollY);

        //2、水平方向和竖直方向移动的距离
        int deltaX = destX - scrollX;
        int deltaY = destY - scrollY;
        Log.e(TAG, "deltaX:" + deltaX + "deltaY:" + deltaY);

        //开始滑动
        //前两个参数：滑动的起点
        //第3,4个参数:滑动的距离
        //最后一个参数：时间
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, 3000);
        //开始刷新
        invalidate();
    }

    /**
     * 父容器请求用来更新子孩子的mScrollX和mScrollY的值。
     */
    @Override
    public void computeScroll() {
        Log.e(TAG, "computeScroll");

        //这个方法用来根据时间比来计算scrollX和scrollY的值
        //如果返回true，表示没有结束，还得继续View的滑动
        if (mScroller.computeScrollOffset()) {
            Log.e(TAG, "mScroller.getCurrX():" + mScroller.getCurrX() + " mScroller.getCurrY():" + mScroller.getCurrY());
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    /**
     * 直接滑动的位置
     * @param destX 水平方向滑动的距离，负值表示向右移动，正值表示向左移动。
     * @param destY 竖直方向滑动的距离，负值表示下移动，正值表示向上移动。
     */
    public void directScrollTo(int destX, int destY) {
        scrollTo(destX,destY);
        postInvalidate();
    }
}
