package com.alibaba.androidhighproject.recyclerrefresh;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.androidhighproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/11                             *
 * 描述 :                                     *
 * *******************************************
 */
public class DiffRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_recycler);

        Button btnAdd = findViewById(R.id.btn_add_data);
        Button btnAlter = findViewById(R.id.btn_alter_data);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        DiffUserRecyclerAdapter adapter = new DiffUserRecyclerAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        List<UserTestBean> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            UserTestBean userTestBean = new UserTestBean();
            userTestBean.setUserId(Integer.parseInt("10" + i));
            userTestBean.setUserName("name_" + i);
            userTestBean.setSubName("subName_" + i);
            userTestBean.setAge((i + 1) * (i / 2));
            list1.add(userTestBean);
        }
        adapter.submitList(list1);

        btnAdd.setOnClickListener(v -> {

            List<UserTestBean> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                UserTestBean userTestBean = new UserTestBean();
                userTestBean.setUserId(Integer.parseInt("10" + i));
                userTestBean.setUserName("name_" + i);
                userTestBean.setSubName("subName_" + i);
                userTestBean.setAge((i + 1) * (i / 2));
                list.add(userTestBean);
            }
            adapter.submitList(list);

        });
        btnAlter.setOnClickListener(v -> {

            List<UserTestBean> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                UserTestBean userTestBean = new UserTestBean();
                userTestBean.setUserId(Integer.parseInt("10" + i));
                userTestBean.setUserName(i % 3 == 0 ? "name_" + i : "name__" + i);
                userTestBean.setSubName("subName_" + i);
                userTestBean.setAge(i % 3 == 0 ? i + 10 : i + 20);
                list.add(userTestBean);
            }
            adapter.submitList(list);
        });


    }
}
