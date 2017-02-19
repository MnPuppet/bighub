package com.zyf.myapplication.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Kelvin
 * @time 2017/2/19 17:02
 * @des 画椭圆
 */

public class DrawOval extends View {

    public DrawOval(Context context) {
        super(context);
    }

    public DrawOval(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawOval(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        //STPOKE 只描边  FILL 只填充  FILL_AND_STROKE  描边和填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //画笔的大小
        paint.setStrokeWidth(10);

        //画椭圆 这里的参数是使用的RectF类
        RectF ps = new RectF(100,100,300,400);
        canvas.drawOval(ps,paint);
    }
}
