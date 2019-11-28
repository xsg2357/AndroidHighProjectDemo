package com.alibaba.androidhighproject.design.ocp;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/11/28                             *
 * 描述 :                                     *
 * *******************************************
 */
public class MyFactoryOcp {

    public  String product(int   type){

        if (type == 0) {
            return "productA";
        }else{
            return "productB";
        }
    }

}
