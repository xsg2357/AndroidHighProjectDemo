package com.alibaba.androidhighproject.http;

import android.util.Log;

import java.net.URL;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2020/1/2                             *
 * 描述 :                                     *
 * *******************************************
 */
public class Api {

    public static final String SERVER_URL = "http://192.168.1.73:4061/";
    public static final String SERVER_NED_URL = "http://192.168.1.73:4062/";
    private static Api instance;
    private Retrofit retrofitNew;

    public static Api getInstance() {
        if (instance == null) {
            synchronized (Api.class) {
                if (instance == null) {
                    instance = new Api();
                }
            }
        }
        return instance;
    }

    public void setApi(int type) {
        Log.d("apiTest", "url==" + SERVER_URL);
        retrofitNew = new Retrofit.Builder()
                .baseUrl(type == 0 ? SERVER_URL : SERVER_NED_URL)
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getClient() {
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .addInterceptor(headerInterceptor)
//                .addInterceptor(new HeaderInterceptor())
//                .connectTimeout(100, TimeUnit.SECONDS)
//                .writeTimeout(100, TimeUnit.SECONDS)
//                .readTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(new BasicAuthInterceptor())
                .retryOnConnectionFailure(true)
                .build();
        return okHttpClient;
    }

    public <T> T create(Class<T> clazz, int type) {
        setApi(type);

        return retrofitNew.create(clazz);
    }

}
