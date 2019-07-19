package com.alibaba.androidhighproject.common

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import java.util.concurrent.TimeUnit

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/19                             *
 * 描述 :                                     *
 * *******************************************
 */
class KtUtils{

    companion object StaticParams{
        fun  <T> preventDupClickTransFormers():ObservableTransformer<T,T>{

            return  ObservableTransformer {
                upstream ->  upstream.throttleFirst(1000, TimeUnit.MILLISECONDS)
            }
        }
    }


}