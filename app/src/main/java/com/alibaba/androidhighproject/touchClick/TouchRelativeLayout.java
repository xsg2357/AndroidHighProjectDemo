package com.alibaba.androidhighproject.touchClick;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import static com.alibaba.androidhighproject.common.Constants.TAG;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/6/24                             *
 * 描述 :                                     *
 * *******************************************
 */
public class TouchRelativeLayout extends RelativeLayout {

    private int i = 0;

    public TouchRelativeLayout(Context context) {
        super(context);
    }


    public TouchRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        i++;
        Log.e(TAG, "--dispatchTouchEvent--:执行了" + i);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "--dispatchTouchEvent--:执行了ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "--dispatchTouchEvent--:执行了ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "--dispatchTouchEvent--:执行了ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "--dispatchTouchEvent--:执行了ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        i++;
        Log.e(TAG, "--onInterceptTouchEvent--:执行了" + i);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "--onInterceptTouchEvent--:执行了ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "--onInterceptTouchEvent--:执行了ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "--onInterceptTouchEvent--:执行了ACTION_UP");
                break;
            default:
                break;

        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        Log.e(TAG, "--onTouchEvent--:执行了" + i);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "--onTouchEvent--:执行了ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "--onTouchEvent--:执行了ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "--onTouchEvent--:执行了ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "--onTouchEvent--:执行了ACTION_CANCEL");
                break;
            default:
                break;

        }
        return super.onTouchEvent(event);
    }

}
