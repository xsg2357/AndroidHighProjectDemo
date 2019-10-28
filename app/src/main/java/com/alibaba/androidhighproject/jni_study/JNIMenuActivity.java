package com.alibaba.androidhighproject.jni_study;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.androidhighproject.R;
import com.alibaba.androidhighproject.adapter.MainContentAdapter;
import com.alibaba.androidhighproject.touchClick.TouchActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * *******************************************
 * 标题 :JNI  开发                             *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/28                          *
 * 描述 :                                     *
 * *******************************************
 */
public class JNIMenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private MainContentAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvMenu = findViewById(R.id.lv_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        //        setSupportActionBar(toolbar);
//        Objects.requireNonNull(getActionBar()).setTitle("JNI开发");
//        toolbar.setTitle("JNI开发");


        String s = new JNI().sayHello();//j
        Log.e("shit", "onCreate: "+s );

        addMenu();
        mAdapter = new MainContentAdapter(this, mData);
        lvMenu.setAdapter(mAdapter);
        lvMenu.setOnItemClickListener(this);
    }

    private void addMenu() {
        mData.add("touchClick:Android_View触摸事件传递机制");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {//touchClick:Android触摸事件传递机制
            startActivity(new Intent(this, TouchActivity.class));
        }
    }
}
