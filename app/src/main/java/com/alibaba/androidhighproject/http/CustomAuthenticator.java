package com.alibaba.androidhighproject.http;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2020/1/2                             *
 * 描述 :                                     *
 * *******************************************
 */
public class CustomAuthenticator implements Authenticator {

    protected CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public Request authenticate(@NotNull Route route, @NotNull Response response) throws IOException {
        Retrofit client = new Retrofit.Builder()
                .baseUrl(Api.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = client.create(ApiService.class);

//        Map<String ,Object > fl = new HashMap<>();
//        fl.put("",);
//        fl.put("",);
//        fl.put("",);
//        Call<String> login = service.login(fl);
//        String body = login.execute().body();
//        if (String !=null){
//
//            return response.request().newBuilder()
//                    .header("Authorization", newaccesstoken)
//                    .build();
//        }else{
//            return null;
//        }
        //        disposable.add(login.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new BaseObserver<String>() {
//                    @Override
//                    protected void onResultSuccess(String s) {
//
//                    }
//
//                    @Override
//                    protected void onResultError(Throwable e) {
//
//                    }
//                }));

        return null;
    }
}
