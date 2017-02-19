package com.zyf.myapplication.customview.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.zyf.myapplication.R;

/**
 * @author Kelvin
 * @time 2017/2/19 17:02
 * @des 绘制图片
 */

public class DrawBitmap extends View {

    public DrawBitmap(Context context) {
        super(context);
    }

    public DrawBitmap(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBitmap(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制图片的时候可以不需要画笔
        //首先获取到图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.head);
        //参数一：图片资源  参数二 开始绘制的坐标  参数三：画笔
        canvas.drawBitmap(bitmap,200,600,null);

        Matrix matrix = new Matrix();
        //设置偏移量
        matrix.postTranslate(20,20);
        //设置拉伸，宽高拉伸两倍
        matrix.postScale(2,2);
        canvas.drawBitmap(bitmap,matrix,null);
    }
}
