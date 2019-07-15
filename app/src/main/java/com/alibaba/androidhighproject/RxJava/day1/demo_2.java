package com.alibaba.androidhighproject.RxJava.day1;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * *******************************************
 * 标题 : do操作符                                *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
      1.doOnSubscribe 一旦观察者订阅Observable 就会被调用
      2.doOnLifecycle 观察者订阅之后 可以设置取消
      3.doOnNext 观察者发射数据一次 就会被调用一次  他的Consumer接收数据 一般用作数据处理
      4. doOnEach 每发出一个数据就会触发这个回调 包括： OnNext  onComplete onError
      5. doAfterNext 在OnNext之后执行 doOnNext在之前执行
      6. doOnComplete  Observable 正常终止会被执行
      7. doFinally Observable 终止后被执行 无论正常还是不正常终止 优先doAfterTerminate执行
      8. doAfterTerminate 注册一个action Observable调用onComplete和onError 执行
 *
 * *
 * *******************************************
 */
public class demo_2 {

    public static void main(String[] args) {
        /**
         * Observable 发射0个和n个操作数据，并已成功和错误阻止
         * Flowable 发射0个和n个操作数据，并已成功和错误阻止 可以被压 控制带数据发射源的剫
         * Single 发射单个数据或者错误事件
         * Complete 从来不发射数据 只处理OnComplete和OnError
         * MayBe 能发射1个和0个数据 要么成功 要么失败
         */
        Observable
                .just("Hello")
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("doOnNext==:");
                    }
                })
                .doAfterNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("doAfterNext==:");
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doOnComplete==:");
                    }
                })
                //订阅之后回调的方法
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnSubscribe==:");
                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doAfterTerminate==:");
                    }
                })
                //Observable 没发出一个数据就会触发这个回调 包括： OnNext  onComplete onError
                .doOnEach(new Consumer<Notification<String>>() {
                    @Override
                    public void accept(Notification<String> stringNotification) throws Exception {
                        String s = stringNotification.isOnNext() ? "onComplete" : "onError";
                        System.out.println("doOnEach==isOnNext:" + s);
                    }
                })
                // 订阅后可以取消
                .doOnLifecycle(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("doOnLifecycle==disposable:" + disposable.isDisposed());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("doOnLifecycle==");
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("收到消息==" + s);
                    }
                });

        /*
         * 输出：
         *          doOnSubscribe==:
         *         doOnLifecycle==disposable:false
         *         doOnNext==:
         *         doOnEach==isOnNext:onComplete
         *         收到消息==Hello
         *         doAfterNext==:
         *         doOnComplete==:
         *         doOnEach==isOnNext:onError
         *         doAfterTerminate==:
         */
    }
}
