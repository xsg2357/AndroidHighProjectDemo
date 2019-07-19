package com.alibaba.androidhighproject.constraint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.androidhighproject.R;
import com.alibaba.androidhighproject.adapter.MainContentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/19                             *
 * 描述 :                                     *
 * *******************************************
 */
public class ConstraintMainAct extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<String> mData = new ArrayList<>();
    private MainContentAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_main);

        ListView lvMenu = findViewById(R.id.lv_menu);

        addMenu();
        mAdapter = new MainContentAdapter(this, mData);
        lvMenu.setAdapter(mAdapter);
        lvMenu.setOnItemClickListener(this);
    }

    private void addMenu() {
        mData.add("constraint（约束布局）:相对位置——parent");
        mData.add("constraint（约束布局）:相对位置——id");
        mData.add("constraint（约束布局）: 尺寸约束");
        mData.add("constraint（约束布局）: percent/ 位置偏向/权重/链");
        mData.add("constraint（约束布局）: 辅助线");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        if (i == 0) {//constraint:相对位置 parent
            startActivity(new Intent(this, ConstraintRelativeParentAct.class));
        }
        if (i == 1) {//constraint:相对位置 id
            startActivity(new Intent(this, ConstraintRelativeIdAct.class));
        }
        if (i == 2) {//constraint:尺寸约束
            startActivity(new Intent(this, ConstraintSizeAct.class));
        }
        if (i == 3) {//percent/ 位置偏向/权重
            startActivity(new Intent(this, ConstraintPercentAct.class));
        }
        if (i == 4) {//辅助线
            startActivity(new Intent(this, ConstraintLineAct.class));
        }
    }
}
