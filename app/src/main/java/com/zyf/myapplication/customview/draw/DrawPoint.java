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
 * @des 画点
 */

public class DrawPoint extends View {

    public DrawPoint(Context context) {
        super(context);
    }

    public DrawPoint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPoint(Context context, AttributeSet attrs, int defStyleAttr) {
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

        //画一个点
        canvas.drawPoint(100,100,paint);

        //画一组点
        //每两个坐标代表一个点，这里画了四个点
        float[] ps = {200,200,300,300,400,400,500,500};
        canvas.drawPoints(ps,paint);
    }
}
