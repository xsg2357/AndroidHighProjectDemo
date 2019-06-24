package com.alibaba.androidhighproject.touchClick;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import static com.alibaba.androidhighproject.common.Constants.TAG;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/6/24                             *
 * 描述 :                                     *
 * *******************************************
 */
@SuppressLint("AppCompatCustomView")
public class TouchTextView extends TextView {

    private int i = 0;

    public TouchTextView(Context context) {
        super(context);
    }

    public TouchTextView(Context context, AttributeSet attrs) {
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
