package com.alibaba.androidhighproject.common;

import android.content.Context;
import android.widget.Toast;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/19                             *
 * 描述 :                                     *
 * *******************************************
 */
public class Utils {

    public static void showToast(Context context,String msg) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }

}
