package com.alibaba.androidhighproject.structure.day01.simple5;

import android.content.Context;

import java.util.Map;

/**
 * Created by hcDarren on 2017/8/26.
 */

public interface IHttpRequest {

    <T> void get(Context context, String url, Map<String, Object> params,
                 final HttpCallBack<T> callback, final boolean cache);

    <T> void post(Context context, String url, Map<String, Object> params,
                  final HttpCallBack<T> callback, final boolean cache);

    <T> void download(Context context, String url, Map<String, Object> params,
                      final HttpCallBack<T> callback);

    <T> void upload(Context context, String url, Map<String, Object> params,
                    final HttpCallBack<T> callback);
}
