package com.alibaba.androidhighproject.constraint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.androidhighproject.R;

/**
 * *******************************************
 * 标题 :  约束布局 ————辅助线      *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 *
 * Guideline可以用来辅助布局，通过Guideline能创建出一条条的水平线或者垂直线，该线不会显示到界面上，
 * 但是能够利用这些线条来添加约束去完成界面的布局。
 * 主要属性如下：
 * android:orientation="horizontal|vertical"
 *     app:layout_constraintGuide_begin="30dp"
 *     app:layout_constraintGuide_end="30dp"
 *     app:layout_constraintGuide_percent="0.5"
 * 属性介绍：
 * android:orientation=”horizontal|vertical”表示是水平或垂直引导线。
 * app:layout_constraintGuide_begin=”30dp”，如果是水平引导线，则距离布局顶部30dp，如果是垂直引导线，则距离布局左边30dp。
 * app:layout_constraintGuide_end=”30dp”，如果是水平引导线，则距离布局底部30dp，如果是垂直引导线，则距离布局右边30dp。
 * app:layout_constraintGuide_percent=”0.5”，如果是水平引导线，则距离布局顶部为整个布局高度的50%，如果是垂直引导线，则距离布局左边文这个布局宽度的50%。
 *
 *
 * *******************************************
 */
public class ConstraintLineAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //这里测试一下 项目的迁移
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_constraint_line);
    }
}
