package com.alibaba.androidhighproject.constraint;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.androidhighproject.R;

/**
 * *******************************************
 * 标题 :  约束布局 ————size                                   *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/15                             *
 * 描述 :
 *
 *ConstraintLayout还能使用百分比来设置view的宽高。
 * 要使用百分比，宽或高同样要设置为0dp（MATCH_CONSTRAINT）。
 * app:layout_constraintWidth_default="percent" //设置宽为百分比
 * app:layout_constraintWidth_percent="0.3" //0到1之间的值
 * 或
 * app:layout_constraintHeight_default="percent" //设置高为百分比
 * app:layout_constraintHeight_percent="0.3" //0到1之间的值
 *
 *
 * 如果想让view的位置偏向某一侧，可以使用以下的两个属性来设置：
 * layout_constraintHorizontal_bias  //水平偏向
 * layout_constraintVertical_bias  //竖直偏向
 * 其值同样也是0到1之间。
 *
 *
 *
 * LinearLayout中可以设置权重，ConstraintLayout同样也有这玩意。
 * app:layout_constraintHorizontal_weight //水平权重
 * app:layout_constraintVertical_weight //竖直权重
 *
 *
 * 将相连的view两两约束好的实际上就形成了链。在ConstraintLayout中可以实现各种不同的链，
 * 权重链是其中一种。整个链由链中的第一个view（链头）上设置的属性控制。
 * app:layout_constraintHorizontal_chainStyle="spread|spread_inside|packed"
 * 默认样式就是spread，所以可以不用设置。然后宽或高非0即可。 Spread Chain = spread + 宽或高非0
 * Spread Inside  宽度同样为非0 Spread Inside Chain = spread_inside + 宽或高非0 app:layout_constraintHorizontal_chainStyle="spread_inside"
 * Weighter Chain 即权重链， Weighter Chain = spread + 宽或高为0 + 权重值
 * Packed Chain 宽度同样为非0
 * Packed是一种view聚拢起来的效果  Packed Chain = packed + 宽或高非0  app:layout_constraintHorizontal_chainStyle="packed"
 * Packed Chain with bias Packed Chain with bias = Packed Chain + bias
 * 就是Packed Chain再加一个偏向属性
 * *******************************************
 */
public class ConstraintPercentAct extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_constraint_percent);
    }
}
