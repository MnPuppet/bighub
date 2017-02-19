package com.zyf.myapplication.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Kelvin
 * @time 2017/2/19 17:02
 * @des 画点
 */

public class DrawTextView extends View {

    public DrawTextView(Context context) {
        super(context);
    }

    public DrawTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        paint.setStrokeWidth(1);

        //设置绘制的文本大小
        paint.setTextSize(50);
        String string = "我爱你，我的宝宝";
        //以某一个点为起点绘制文本
        canvas.drawText(string,100,100,paint);

        Path path = new Path();
        //设置圆的路径
        //参数一：圆心（500,500） 参数二：半径  参数三：文字显示的方向（顺时针，逆时针）
        path.addCircle(500,500,200, Path.Direction.CW);
        //在指定的路径上绘制文字
        canvas.drawTextOnPath(string,path,0,0,paint);

        //在矩形上画
        path = new Path();
        RectF ps = new RectF(100,100,300,400);
        path.addRect(ps, Path.Direction.CW);
        canvas.drawTextOnPath(string,path,10,10,paint);


    }
}
