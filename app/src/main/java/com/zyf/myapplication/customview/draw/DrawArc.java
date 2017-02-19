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
 * @des 画圆弧
 */

public class DrawArc extends View {

    public DrawArc(Context context) {
        super(context);
    }

    public DrawArc(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawArc(Context context, AttributeSet attrs, int defStyleAttr) {
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

        RectF rectF = new RectF(100,100,600,400);
        //参数一：坐标开始点和结束点  参数二：圆弧的度数  参数三：是否有圆心  参数四：画笔
        canvas.drawArc(rectF,0,60,true,paint);
    }
}
