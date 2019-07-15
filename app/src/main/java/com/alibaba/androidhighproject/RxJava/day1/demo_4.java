package com.alibaba.androidhighproject.RxJava.day1;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

/**
 * *******************************************
 * 标题 :     cold    Observable  ————》Hot Observable *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 *     1.使用publish 生成ConnectableObservable(线程安全)
 *              cold    Observable  ————》Hot Observable
 *              Observable    ———————————》 ConnectableObservable
 * *******************************************
 */
public class demo_4 {

    public static void main(String[] args) {
        Consumer<Long> longConsumer = aLong -> System.out.println("longConsumer ==" + aLong);
        Consumer<Long> longConsumer1 = aLong -> System.out.println("longConsumer1 ==" + aLong);
        Consumer<Long> longConsumer2 = aLong -> System.out.println("longConsumer2 ==" + aLong);
        //ConnectableObservable 生成了 必须调用 才会生效
        ConnectableObservable<Long> observable = Observable.create((ObservableOnSubscribe<Long>) emitter -> Observable
                .interval(10, TimeUnit.MILLISECONDS, Schedulers.computation())
                .take(Integer.MAX_VALUE)
                .subscribe(emitter::onNext)).observeOn(Schedulers.newThread()).publish();

        observable.connect();

        observable.subscribe(longConsumer);
        observable.subscribe(longConsumer1);
        try {
            Thread.sleep(20L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        observable.subscribe(longConsumer2);


        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * 输出：
         * longConsumer ==0
         * longConsumer1 ==0
         * longConsumer ==1
         * longConsumer1 ==1
         * longConsumer ==2
         * longConsumer1 ==2
         * longConsumer2 ==2
         * longConsumer ==3
         * longConsumer1 ==3
         * longConsumer2 ==3
         * longConsumer ==4
         * longConsumer1 ==4
         * longConsumer2 ==4
         * longConsumer ==5
         * longConsumer1 ==5
         * longConsumer2 ==5
         * longConsumer ==6
         * longConsumer1 ==6
         * longConsumer2 ==6
         * longConsumer ==7
         * longConsumer1 ==7
         * longConsumer2 ==7
         * longConsumer ==8
         * longConsumer1 ==8
         * longConsumer2 ==8
         * longConsumer ==9
         * longConsumer1 ==9
         * longConsumer2 ==9
         * longConsumer ==10
         * longConsumer1 ==10
         * longConsumer2 ==10
         * longConsumer ==11
         * longConsumer1 ==11
         * longConsumer2 ==11
         */
    }
}
