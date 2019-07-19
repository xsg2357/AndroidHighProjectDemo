package com.alibaba.androidhighproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.androidhighproject.RxJava.binding.RxBindingTest1Act;
import com.alibaba.androidhighproject.adapter.MainContentAdapter;
import com.alibaba.androidhighproject.constraint.ConstraintLineAct;
import com.alibaba.androidhighproject.constraint.ConstraintMainAct;
import com.alibaba.androidhighproject.constraint.ConstraintPercentAct;
import com.alibaba.androidhighproject.constraint.ConstraintRelativeIdAct;
import com.alibaba.androidhighproject.constraint.ConstraintRelativeParentAct;
import com.alibaba.androidhighproject.constraint.ConstraintSizeAct;
import com.alibaba.androidhighproject.touchClick.TouchActivity;
import com.alibaba.androidhighproject.touchClick.TouchGroupActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private MainContentAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView lvMenu = findViewById(R.id.lv_menu);

        addMenu();
        mAdapter = new MainContentAdapter(this, mData);
        lvMenu.setAdapter(mAdapter);
        lvMenu.setOnItemClickListener(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }


    private void addMenu() {
        mData.add("touchClick:Android_View触摸事件传递机制");
        mData.add("touchClick:Android_ViewGroup触摸事件传递机制");
        mData.add("constraint（约束布局）");
        mData.add("RxBinding:RxBindingTest1Act");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) {//touchClick:Android触摸事件传递机制
            startActivity(new Intent(this, TouchActivity.class));
        }
        if (i == 1) {//touchClick:Android_ViewGroup触摸事件传递机制
            startActivity(new Intent(this, TouchGroupActivity.class));
        }
        if (i == 2) {//constraint:相对位置 parent
            startActivity(new Intent(this, ConstraintMainAct.class));
        }
        if (i == 3) {//constraint:相对位置 parent
            startActivity(new Intent(this, RxBindingTest1Act.class));
        }

    }
}
