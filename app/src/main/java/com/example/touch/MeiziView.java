package com.example.touch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;

public class MeiziView extends View {
    /* 定义相关变量,依次是妹子显示位置的X,Y坐标 */
    public float bitmapX;
    public float bitmapY;
    public Context context;
    public Bitmap bitmap;

    public MeiziView(Context context) {
        super(context);
        this.context = context;
        /* 设置妹子的起始坐标 */
        bitmapX = 0;
        bitmapY = 200;
    }

    //定义走路时切换图片的方法
    public void move(int i)
    {

        //通过setForeground来设置前景图像
        switch(i)
        {
            case 0:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_1);
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_2);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_3);
                break;
            case 3:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_4);
                break;
            case 4:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_5);
                break;
            case 5:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_6);
                break;
            case 6:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_7);
                break;
            case 7:
                bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_8);
                break;
        }


    }
    //重写View类的onDraw()方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /* 创建,并且实例化Paint的对象 */
        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        /* 根据图片生成位图对象 */
        //bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_jump);
        /* 绘制萌妹子 */
        canvas.drawBitmap(bitmap, bitmapX, bitmapY,paint);
    }
}
