package com.zyf.myapplication.customview.baseknowledge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Kelvin
 * @time 2017/2/19 16:38
 * @des ${TODO}
 */

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //创建画笔对象
        Paint paint = new Paint();
        //设置画笔参数
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        //设置抗锯齿（我们画出来的东西是圆滑的，不能有棱角）
        paint.setAntiAlias(true);
        //参数一：圆心坐标X轴，参数二：圆心坐标Y轴，参数三：半径 参数四：画笔
        //坐标以控件开始位置计算
        canvas.drawCircle(100,100,30, paint);

        canvas.drawCircle(100,100,60, paint);
    }
}
