package com.alibaba.androidhighproject;

import android.app.Application;

import com.alibaba.androidhighproject.structure.day01.simple5.HttpUtils;
import com.alibaba.androidhighproject.structure.day01.simple5.OKHttpRequest;
import com.alibaba.androidhighproject.structure.day01.simple5.PreferencesUtil;


/**
 * description:
 * author: Darren on 2017/8/21 15:05
 * email: 240336124@qq.com
 * version: 1.0
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * share缓存优化
         */
        PreferencesUtil.getInstance().init(this);
        /**
         * 初始化面对六大基本原则的网络切换引擎
         */
        HttpUtils.initHttpRequest(new OKHttpRequest());
    }
}
