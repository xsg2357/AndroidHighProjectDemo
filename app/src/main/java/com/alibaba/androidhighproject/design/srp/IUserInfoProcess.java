package com.alibaba.androidhighproject.design.srp;

/**
 * *******************************************
 * 标题 :  经过单一开闭原则的拆分的业务方法                                 *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/11/28                             *
 * 描述 :                                     *
 * *******************************************
 */
public interface IUserInfoProcess {
    void  addUser(int  id,String name,String password);

    void  delUser(int  id);

}
