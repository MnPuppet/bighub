package com.zyf.myapplication.customview.baseknowledge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Kelvin
 * @time 2017/2/19 16:10
 * @des ${TODO}
 */

public class LayoutView extends ViewGroup {


    public LayoutView(Context context) {
        super(context);
    }

    public LayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount()>0) {
            View childView = getChildAt(0);
            //测量子控件的大小
            //参数一：要测量的子控件  参数二：父控件的宽度  参数三：父控件的高度
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }

    /**
     * 设置子控件的位置
     * @param changed view有新的尺寸或位置
     * @param l 表示相对于父view的Left位置
     * @param t 表示相对于父view的Top位置
     * @param r 表示相对于父view的Right位置
     * @param b 表示相对于父view的Bottom位置
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //getChildCount()  获取容器中子控件的个数
        if (getChildCount()>0) {
            View view = getChildAt(0); //获取第一个控件
            //设置子控件的大小
            //如果要动态设置，必须先在onMeasure（）中测量一下子控件的宽和高，如果不测量，默认值都是0
            view.layout(10,10,view.getMeasuredWidth()+10,getMeasuredHeight()+10);
        }
    }
}
