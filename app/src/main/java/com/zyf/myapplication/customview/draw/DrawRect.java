package com.zyf.myapplication.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Kelvin
 * @time 2017/2/19 17:02
 * @des 画矩形
 */

public class DrawRect extends View {

    public DrawRect(Context context) {
        super(context);
    }

    public DrawRect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawRect(Context context, AttributeSet attrs, int defStyleAttr) {
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

        //画矩形 这里的参数是使用的RectF类
        RectF ps = new RectF(100,100,300,400);
        canvas.drawRect(ps,paint);
        //RectF和Rect的功能是一样的，区别是精度不一样，Rect是int  RectF是float
        Rect rect = new Rect(500,500,800,900);
        canvas.drawRect(rect,paint);
    }
}
