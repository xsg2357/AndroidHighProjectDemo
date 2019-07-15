package com.alibaba.androidhighproject.RxJava.day1;

import android.annotation.SuppressLint;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 *      1.RxJava中被观察者、观察者、subscribe缺一不可
 *      2.只有使用了subscribe 才会发送数据
 *      3.5种观察者模式如下：
 *         Observable和Observer
 *         Flowable和subscribe
 *         single和singleObserver
 *         Complete和CompleteObserver
 *         MayBe和MayBeObserver
 *         *
 * *******************************************
 */
public class demo_1 {


    @SuppressLint("CheckResult")
    public static void main(String[] args) {
        /*
         * 1.创建Observable 决定什么时候触发事件以及怎么触发事件 （异步操作顺序和异步操作模块的次数）
         * 2.创建Observer 在不同的线程中执行任务 不需要阻塞等待创建Observable发射的数据
         * 3.subscribe订阅接收 链接上下操作
         */
        Observable
                .just("Hello World") //RxJava创建操作符
                .subscribe(new Consumer<String>() {//消费者 用于接收单个值
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("s == " + s);
                    }
                });
        //输出：
        // s == Hello World

        //1.subscribe(onNext , onError , onComplete)
        Observable
                .just("Hello World") //RxJava创建操作符
                .subscribe(new Consumer<String>() {//Consumer 单一参数类型
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("s == " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("throwable == " + throwable.getMessage())
                        ;
                    }
                }, new Action() {//Action 无参数类型 onComplete是一个Action
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete == ");
                    }
                });
       /*
        输出：
       s == Hello World
        onComplete ==*/
        //2.subscribe(onNext , onError , onComplete,onSubscribe)
        Observable
                .just("Hello World") //RxJava创建操作符
                .subscribe(new Consumer<String>() {//Consumer 单一参数类型
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("s == " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("throwable == " + throwable.getMessage())
                        ;
                    }
                }, new Action() {//Action 无参数类型 onComplete是一个Action
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete == ");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("onSubscribe == ");
                    }
                });

        /*
         * 输出：
         * onSubscribe ==
         * s == Hello World
         * onComplete ==
         */
        //Observable不再支持Subscribe订阅，需要使用Observer作为观察者
        Observable
                .just("Hello World")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("Disposable == ");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext == " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError == " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete == ");
                    }
                });
        /*
         * 输出：
         * Disposable ==
         * onNext == Hello World
         * onComplete ==
         */
    }
}
