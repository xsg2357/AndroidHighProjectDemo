package com.alibaba.androidhighproject.design.srp;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/11/28                             *
 * 描述 :                                     *
 * *******************************************
 */
public interface IUserInfoOri {
    void getId();

    void  setId(int  id);

    void getName();

    void  setName(String  name);

    void getPassword();

    void  setPassword(String  password);

    void  addUser(int  id,String name,String password);

    void  delUser(int  id);

}
