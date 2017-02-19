package com.zyf.myapplication.customview.baseknowledge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * @author Kelvin
 * @time 2017/2/19 15:45
 * @des ${TODO}
 */

public class MeasureView extends View {

    /**
     * Java代码中创建对象时饮用
     * @param context
     */
    public MeasureView(Context context) {
        super(context);
    }

    /**
     * 布局应用的时候使用
     * @param context
     * @param attrs
     */
    public MeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 布局应用的时候使用
     * @param context
     * @param attrs
     */
    public MeasureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 这个方法是设置该控件的大小及形式
     * @param widthMeasureSpec  既有大小又有模式（宽度）
     * @param heightMeasureSpec 高度
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取控件的大小（宽度）
        int size = MeasureSpec.getSize(widthMeasureSpec);
        //获取控件的模式
        int mode = MeasureSpec.getMode(widthMeasureSpec);

        //MeasureSpec有三种模式:
        // EXACTLY是当我们将控件的layout_width或layout_height指定为具体数值时如andorid:layout_width="50dp"，
        // 或者为MATCH_PARENT是，都是控件大小已经确定的情况，都是精确尺寸。
        //AT_MOST是最大尺寸，当控件的layout_width或layout_height指定为WRAP_CONTENT时，控件大小一般随着控件的子控件
        // 或内容进行变化，此时控件尺寸只要不超过父控件允许的最大尺寸即可。因此，此时的mode是AT_MOST，size给出了父控件允许的最大尺寸。
        //UNSPECIFIED是未指定尺寸，这种情况不多，一般都是父控件是AdapterView，通过measure方法传入的模式。
        if (mode == MeasureSpec.EXACTLY){
            Toast.makeText(getContext(),"宽度："+size+"模式是精确模式",Toast.LENGTH_SHORT).show();
        }

        //这个方法是设置控件的大小，如果不写这个方法，控件显示是以XML文件设置的为准
        //设置这个方法则是以此方法为准
        setMeasuredDimension(200,200);
    }
}
