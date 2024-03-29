package com.example.touch;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.app.Activity;
import android.graphics.drawable.Drawable;

public class MoveActivity extends Activity {

    //初始化变量,帧布局
    private FrameLayout frame = null;
    private MeiziView mezi = null;
    //自定义一个用于定时更新UI界面的handler类对象
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler()
    {
        int i = 0;
        @Override
        public void handleMessage(Message msg) {
            //判断信息是否为本应用发出的
            if(msg.what == 0x123)
            {
                i++;
                mezi.move(i % 8 );

                mezi.invalidate();
                /* 判断图片是否回收,木有回收的话强制收回图片 */
                if(mezi.bitmap.isRecycled())
                {
                    mezi.bitmap.recycle();
                }
            }
            super.handleMessage(msg);
        }
    };
    //定义走路时切换图片的方法
    /*private void move(int i)
    {
        Drawable a = getResources().getDrawable(R.drawable.s_1);
        Drawable b = getResources().getDrawable(R.drawable.s_2);
        Drawable c = getResources().getDrawable(R.drawable.s_3);
        Drawable d = getResources().getDrawable(R.drawable.s_4);
        Drawable e = getResources().getDrawable(R.drawable.s_5);
        Drawable f = getResources().getDrawable(R.drawable.s_6);
        Drawable g = getResources().getDrawable(R.drawable.s_7);
        Drawable h = getResources().getDrawable(R.drawable.s_8);
        //通过setForeground来设置前景图像
        switch(i)
        {
            case 0:
                frame.setForeground(a);
                break;
            case 1:
                frame.setForeground(b);
                break;
            case 2:
                frame.setForeground(c);
                break;
            case 3:
                frame.setForeground(d);
                break;
            case 4:
                frame.setForeground(e);
                break;
            case 5:
                frame.setForeground(f);
                break;
            case 6:
                frame.setForeground(g);
                break;
            case 7:
                frame.setForeground(h);
                break;
        }
    }*/
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meizi);
        frame = (FrameLayout) findViewById(R.id.mylayout);



        frame = (FrameLayout) findViewById(R.id.mylayout);

        mezi = new MeiziView(MoveActivity.this);
        //定义一个定时器对象,定时发送信息给handler
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                //发送一条空信息来通知系统改变前景图片
                handler.sendEmptyMessage(0x123);
            }
        }, 0,170);
        //为我们的萌妹子添加触摸事件监听器

        mezi.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //* 设置妹子显示的位置
                mezi.bitmapX = event.getX()-300;
                mezi.bitmapY = event.getY()-300;

                //调用重绘方法
                //System.out.print("调用重绘方法 x:"+ mezi.bitmapX+"    y:"+  mezi.bitmapY)

                return true;
            }
        });
        frame.addView(mezi);
    }
}
