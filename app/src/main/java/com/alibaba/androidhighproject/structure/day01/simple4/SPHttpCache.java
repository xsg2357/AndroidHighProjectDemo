package com.alibaba.androidhighproject.structure.day01.simple4;

/**
 * Created by hcDarren on 2017/8/26.
 */

public class SPHttpCache {
    public void saveCache(String finalUrl,String resultJson){
        PreferencesUtil.getInstance().saveParam(finalUrl,resultJson);
    }

    public String getCache(String finalUrl){
        return (String) PreferencesUtil.getInstance().getObject(finalUrl);
    }
}
