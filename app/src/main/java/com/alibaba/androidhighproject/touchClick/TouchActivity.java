package com.alibaba.androidhighproject.touchClick;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.androidhighproject.R;

import static com.alibaba.androidhighproject.common.Constants.TAG;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/6/24                             *
 * 描述 :                                     *
 * *******************************************
 */
public class TouchActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        TouchTextView touchTextView = findViewById(R.id.tv_touch);
        TextView back = findViewById(R.id.tv_back);

        touchTextView.setOnClickListener(this);
        back.setOnClickListener(this);

        touchTextView.setOnTouchListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "Activity--dispatchTouchEvent--:执行了");
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "Activity--dispatchTouchEvent--:执行了ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "Activity--dispatchTouchEvent--:执行了ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "Activity--dispatchTouchEvent--:执行了ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "Activity--dispatchTouchEvent--:执行了ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "Activity--onTouchEvent--:执行了");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "Activity--onTouchEvent--:执行了ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "Activity--onTouchEvent--:执行了ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "Activity--onTouchEvent--:执行了ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "Activity--onTouchEvent--:执行了ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_touch:
                Log.e(TAG, "Activity--TouchTextView--:执行了");
                break;
            case R.id.tv_back:
                finish();
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()) {
            case R.id.tv_touch:
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG, "Activity-TouchTextView-onTouchEvent--:执行了ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e(TAG, "Activity-TouchTextView-onTouchEvent--:执行了ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "Activity-TouchTextView-onTouchEvent--:执行了ACTION_UP");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return false;
    }
}
