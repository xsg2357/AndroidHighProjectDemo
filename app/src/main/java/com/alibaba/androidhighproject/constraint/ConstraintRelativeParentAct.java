package com.alibaba.androidhighproject.constraint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.androidhighproject.R;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 * 相对位置的属性：
 * layout_constraintLeft_toLeftOf
 * layout_constraintLeft_toRightOf
 * layout_constraintRight_toLeftOf
 * layout_constraintRight_toRightOf
 * layout_constraintTop_toTopOf
 * layout_constraintTop_toBottomOf
 * layout_constraintBottom_toTopOf
 * layout_constraintBottom_toBottomOf
 * layout_constraintBaseline_toBaselineOf
 * layout_constraintStart_toEndOf
 * layout_constraintStart_toStartOf
 * layout_constraintEnd_toStartOf
 * layout_constraintEnd_toEndOf
 * 这些属性的值即可以是parent，也可以是某个view的id
 * *******************************************
 */
public class ConstraintRelativeParentAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_constraint_relative);
    }
}
