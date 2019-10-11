package com.alibaba.androidhighproject.recyclerrefresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/10/11                             *
 * 描述 :                                     *
 * *******************************************
 */
public class MyDiffItemCallback  extends DiffUtil.ItemCallback<UserTestBean> {

    /**
     * 根据元素中的一个唯一标识判断是不是同一个Item
     */
    @Override
    public boolean areItemsTheSame(@NonNull UserTestBean userTestBean, @NonNull UserTestBean t1) {
        return userTestBean.getUserId() == t1.getUserId();
    }

    /**
     * 比较每个Item里面的每个元素是不是相同
     */
    @Override
    public boolean areContentsTheSame(@NonNull UserTestBean userTestBean, @NonNull UserTestBean t1) {

        if (userTestBean.getAge() != t1.getAge()){
            return  false;
        }
        if (!userTestBean.getSubName().equals(t1.getSubName())){
            return  false;
        }
        return userTestBean.getUserName().equals(t1.getUserName());
    }

    /**
     * 在这里 可以刷新局部控件，回调给onBindViewHolder
     */
    @Nullable
    @Override
    public Object getChangePayload(@NonNull UserTestBean oldItem, @NonNull UserTestBean newItem) {

        Bundle bundle = new Bundle();

        if (!TextUtils.equals(oldItem.getSubName(),newItem.getSubName())){
            bundle.putString("subName",newItem.getSubName());
        }
        if (!TextUtils.equals(oldItem.getUserName(),newItem.getUserName())){
            bundle.putString("userName",newItem.getUserName());
        }
        if (oldItem.getAge() != newItem.getAge()){
            bundle.putInt("age",newItem.getAge());
        }

        return bundle;
    }
}
