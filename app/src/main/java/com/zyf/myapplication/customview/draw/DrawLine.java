package com.zyf.myapplication.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Kelvin
 * @time 2017/2/19 17:02
 * @des 画线
 */

public class DrawLine extends View {

    public DrawLine(Context context) {
        super(context);
    }

    public DrawLine(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        //STPOKE 只描边  FILL 只填充  FILL_AND_STROKE  描边和填充
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //画笔的大小
        paint.setStrokeWidth(10);

        //画一条线
//        canvas.drawLine(50,50,300,300,paint);

        //画一组线
        //每两个坐标代表一个点，这里画了四个点
        float[] ps = {300,300,400,400,400,400,500,400,500,400,400,500,400,500,500,700,500,700,300,600,
                300,600,100,700,100,700,200,500,200,500,100,400,100,400,200,400,200,400,300,300};
        canvas.drawLines(ps,paint);
    }
}
