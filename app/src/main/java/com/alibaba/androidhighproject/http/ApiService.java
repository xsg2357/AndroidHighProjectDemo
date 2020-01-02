package com.alibaba.androidhighproject.http;


import com.google.gson.JsonObject;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2020/1/2                            *
 * 描述 :                                     *
 * *******************************************
 */
public interface ApiService {

//    @FormUrlEncoded
    @POST("identity/connect/token")
    Observable<JsonObject> login(@Body RequestBody params);


    @GET("api/Test/load")
    Observable<JsonObject> load(@QueryMap Map<String,Object> params);
}
