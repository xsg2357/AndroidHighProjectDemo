package com.alibaba.androidhighproject.jni_study;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/28                             *
 * 描述 :JNI调用对应的C代码                          *
 * *******************************************
 */
public class JNI {

    static {
        System.loadLibrary("Hello");
    }



    public  native  String sayHello();
}
