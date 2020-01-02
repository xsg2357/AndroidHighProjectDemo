package com.alibaba.androidhighproject.http;

import io.reactivex.observers.DisposableObserver;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2020/1/2                             *
 * 描述 :                                     *
 * *******************************************
 */
public abstract class BaseObserver<T> extends DisposableObserver<T> {


    @Override
    public void onNext(T t) {
        onResultSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onResultError(e);
    }

    @Override
    public void onComplete() {

    }


    protected abstract  void  onResultSuccess(T t);

    protected  abstract void  onResultError(Throwable e);
}
