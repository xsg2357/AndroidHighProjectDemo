package com.alibaba.androidhighproject.RxJava.day1;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * *******************************************
 * 标题 :Hot Observable     和cold    Observable                 *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 * Hot Observable  无论有没有进行订阅 都会进行
 * 有多个订阅者，关系是一对多 可以与订阅者之间进行共享信息
 * 作用于Ui交互时间。网络变化。位置变化 服务器消息推送等*
 * cold Observable
 * Observable和Observer是一对一关系，只有观察者订阅了，才会开始发送数据
 * 多个不同订阅者，消息重新完整发送
 * *******************************************
 */
public class demo_3 {

    public static void main(String[] args) {
        Consumer<Long> longConsumer = aLong -> System.out.println("longConsumer ==" + aLong);
        Consumer<Long> longConsumer1 = aLong -> System.out.println("longConsumer1 ==" + aLong);
        Observable<Long> observable = Observable.create((ObservableOnSubscribe<Long>) emitter -> Observable
                .interval(10, TimeUnit.MILLISECONDS, Schedulers.computation())
                .take(Integer.MAX_VALUE)
                .subscribe(emitter::onNext)).observeOn(Schedulers.newThread());

        observable.subscribe(longConsumer);
        observable.subscribe(longConsumer1);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * 输出：
         * longConsumer1 ==0
         * longConsumer ==0
         * longConsumer1 ==1
         * longConsumer ==1
         * longConsumer1 ==2
         * longConsumer ==2
         * longConsumer ==3
         * longConsumer1 ==3
         * longConsumer1 ==4
         * longConsumer ==4
         * longConsumer1 ==5
         * longConsumer ==5
         * longConsumer1 ==6
         * longConsumer ==6
         * longConsumer ==7
         * longConsumer1 ==7
         * longConsumer ==8
         * longConsumer1 ==8
         */
    }
}
