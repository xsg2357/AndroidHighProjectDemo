package com.alibaba.androidhighproject.structure.day01.simple2;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.androidhighproject.R;
import com.alibaba.androidhighproject.structure.day01.ConstantValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Simple2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /********************访问网络开始*******************/
        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("iid", 6152551759L);
        params.put("aid", 7);

        HttpUtils.get(this, ConstantValue.UrlConstant.HOME_DISCOVERY_URL, params, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                // 失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String resultJson = response.body().string();
                Log.e("TAG", resultJson);
                // 1.JSON解析转换

                // 2.显示列表数据

                // 3.缓存数据
            }
        });
        /********************访问网络结束*******************/
    }
}
