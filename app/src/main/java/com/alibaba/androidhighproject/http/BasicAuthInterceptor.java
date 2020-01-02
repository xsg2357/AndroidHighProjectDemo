package com.alibaba.androidhighproject.http;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2020/1/2                             *
 * 描述 :                                     *
 * *******************************************
 */
public class BasicAuthInterceptor implements Interceptor {

    private String credentials;
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    public BasicAuthInterceptor() {
        this.credentials = Credentials.basic("app_test_id", "F621F470-9731-4A25-80EF-67A6F7C5F4B8");

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);
    }
}