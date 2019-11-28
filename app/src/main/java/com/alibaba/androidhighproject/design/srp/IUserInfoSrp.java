package com.alibaba.androidhighproject.design.srp;

/**
 * *******************************************
 * 标题 : 经过单一开闭原则的拆分属性方法          *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/11/28                             *
 * 描述 :                                     *
 * *******************************************
 */
public interface IUserInfoSrp {
    void getId();

    void  setId(int id);

    void getName();

    void  setName(String name);

    void getPassword();

    void  setPassword(String password);



}
