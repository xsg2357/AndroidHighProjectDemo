package com.alibaba.androidhighproject.structure.day01.simple1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


import com.alibaba.androidhighproject.R;
import com.alibaba.androidhighproject.structure.day01.ConstantValue;
import com.alibaba.androidhighproject.structure.day01.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Simple1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /********************访问网络开始*******************/
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Map<String, Object> params = new HashMap<>();
        // 特定参数
        params.put("iid", 6152551759L);
        params.put("aid", 7);
        // 公共参数
        params.put("app_name", "joke_essay");
        params.put("version_name", "5.7.0");
        params.put("ac", "wifi");
        params.put("device_id", "30036118478");
        params.put("device_brand", "Xiaomi");
        params.put("update_version_code", "5701");
        params.put("manifest_version_code", "570");
        params.put("longitude", "113.000366");
        params.put("latitude", "28.171377");
        params.put("device_platform", "android");

        final String jointUrl = Utils.jointParams(ConstantValue.UrlConstant.HOME_DISCOVERY_URL, params);  //打印
        Log.e("Post请求路径：", jointUrl);

        Request.Builder requestBuilder = new Request.Builder().url(jointUrl).tag(this);
        //可以省略，默认是GET请求
        Request request = requestBuilder.build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
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
