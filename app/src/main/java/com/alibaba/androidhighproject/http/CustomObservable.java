package com.alibaba.androidhighproject.http;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2020/1/2                             *
 * 描述 :                                     *
 * *******************************************
 */
public class CustomObservable<T>  {

    private Observable<T>  methodObservable;

    public CustomObservable(Observable<T> methodObservable) {
        this.methodObservable = methodObservable;
    }

    private  CompositeDisposable disposable = new CompositeDisposable();

    public  void   excuteRequest(){
        disposable.add(methodObservable.subscribeOn(Schedulers.newThread())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribeWith(new BaseObserver<T>() {
                       @Override
                       protected void onResultSuccess(T t) {

                       }

                       @Override
                       protected void onResultError(Throwable e) {

                       }
                   }));
    }


}
