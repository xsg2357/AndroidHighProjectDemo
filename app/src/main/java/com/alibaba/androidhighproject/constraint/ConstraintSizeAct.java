package com.alibaba.androidhighproject.constraint;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.androidhighproject.R;

/**
 * *******************************************
 * 标题 :  约束布局 ————size                                   *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 *
 *view中使用warp_content或者固定值等等是没有问题的。但是在ConstraintLayout中不推荐使用MATCH_PARENT这个值，
 * 如果需要实现跟MATCH_PARENT同样的效果，可以使用0dp来代替，其表示MATCH_CONSTRAINT,即适应约束。其跟MATCH_PARENT还是有区别的
 *
 * 在ConstraintLayout中，还可以将宽定义成高的一个比例或者高定义成宽的比率。首先，需要将宽或者高设置为0dp（即MATCH_CONSTRAINT），
 * 即要适应约束条件。然后通过layout_constraintDimensionRatio属性设置一个比率即可
 * 。这个比率可以是一个浮点数，表示宽度和高度之间的比率；也可以是“宽度：高度”形式的比率。
 *
 * 如果宽和高都设置为0dp（MATCH_CONSTRAINT），
 * 那么layout_constraintDimensionRatio的值需要先加一个"W,"或者"H,"来表示约束宽度或高度
 *
 * *******************************************
 */
public class ConstraintSizeAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_constraint_size);
    }
}
