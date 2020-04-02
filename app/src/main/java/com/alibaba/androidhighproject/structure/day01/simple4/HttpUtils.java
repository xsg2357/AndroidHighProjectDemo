package com.alibaba.androidhighproject.structure.day01.simple4;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * author: Darren on 2017/8/21 11:36
 * email: 240336124@qq.com
 * version: 1.0
 */
public class HttpUtils {
    private OKHttpRequest mHttpRequest;
    private final int TYPE_POST = 0x0011,TYPE_GET = 0x0022;
    private int mType = TYPE_GET;
    private Map<String,Object> mParams;
    private String mUrl;
    private Context mContext;

    public static HttpUtils with(Context context){
        return new HttpUtils(context);
    }

    public HttpUtils get(){
        mType = TYPE_GET;
        return this;
    }

    private HttpUtils(Context context) {
        mHttpRequest = new OKHttpRequest();
        mParams = new HashMap<>();
        this.mContext = context;
    }

    public HttpUtils param(String key,Object value){
        mParams.put(key,value);
        return this;
    }

    public HttpUtils url(String url){
        this.mUrl = url;
        return this;
    }

    public HttpUtils cache(boolean cache){
        // TODO
        return this;
    }

    public <T> void request(){
        request(null);
    }

    public <T> void request(final HttpCallBack<T> callback){
        // 异常判断
        mHttpRequest.get(mContext,mUrl,mParams,callback,true);
    }

    /*public  <T> void get(Context context, String url, Map<String, Object> params, final HttpCallBack<T> callback, final boolean cache) {
        mHttpRequest.get(context,url,params,callback,cache);
    }
    // 10几个参数以上
    public  <T> void get(Context context, String url, Map<String, Object> params,
                         final HttpCallBack<T> callback, final boolean cache,final boolean cookie,int recount) {
        mHttpRequest.get(context,url,params,callback,cache);
    }*/
}
