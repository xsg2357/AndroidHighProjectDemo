package com.alibaba.androidhighproject.design.ocp;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/11/28                             *
 * 描述 :                                     *
 * *******************************************
 */
public class Client01Ori {

    public static void main(String[] args) {

        System.out.println("ori:"+order());

        System.out.println("ocp1:"+order1());
        System.out.println("ocp2:"+order2());

        System.out.println("ori1-ocp:"+order3()); //推荐使用
        System.out.println("ori2-ocp:"+order4()); //推荐使用
        System.out.println("ori2-ocp:"+order5()); //推荐使用

    }


    //原有的产品
    private  static  String  order(){
        MyFactoryOri myFactoryOri = new MyFactoryOri();
        return  myFactoryOri.product();
    }

    private  static  String  order3(){
        MyFactoryOri myFactoryOri = new MyFactoryOri();
        return  myFactoryOri.product1();
    }

    //现有的ocp产品1
    private  static  String  order1(){
        MyFactoryOcp myFactoryOri = new MyFactoryOcp();
        return  myFactoryOri.product(0);
    }

    //现有的ocp产品2
    private  static  String  order2(){
        MyFactoryOcp myFactoryOri = new MyFactoryOcp();
        return  myFactoryOri.product(2);
    }

    //现有的ocp产品3
    private  static  String  order4(){
        MyFactoryImpl myFactoryOri = new MyFactoryImpl();
        return  myFactoryOri.procduct();
    }
    //现有的ocp产品3
    private  static  String  order5(){
        MyFactory02Impl myFactoryOri = new MyFactory02Impl();
        return  myFactoryOri.procduct();
    }


}
