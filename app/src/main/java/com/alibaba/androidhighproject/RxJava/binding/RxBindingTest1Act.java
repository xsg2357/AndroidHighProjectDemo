package com.alibaba.androidhighproject.RxJava.binding;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.androidhighproject.R;
import com.alibaba.androidhighproject.common.KtUtils;
import com.alibaba.androidhighproject.common.Utils;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.widget.RxTextView;

/**
 * *******************************************
 * 标题 :                                     *
 * 编辑 : 向绍谷                               *
 * 日期 : 2019/7/19                             *
 * 描述 :                                     *
 * *******************************************
 */
public class RxBindingTest1Act extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_rxb_test1);
        Button button = findViewById(R.id.buttonPanel);
        EditText editText = findViewById(R.id.edit_query);
        Button button1 = findViewById(R.id.buttonPanel1);
        Button button2 = findViewById(R.id.buttonPanel2);
        RxView.clicks(button).subscribe(unit -> {
            Utils.showToast(RxBindingTest1Act.this,"Button点击引用le");
        });
        RxTextView.textChanges(editText).subscribe(charSequence -> {
            Utils.showToast(RxBindingTest1Act.this,"EditText"+charSequence);
        });
        RxView.longClicks(button1).subscribe(unit -> {
            Utils.showToast(RxBindingTest1Act.this,"Button长安引用le");
        });
   /*     RxView.longClicks(button)
                .compose(upstream -> upstream.compose(
                        KtUtils.StaticParams.preventDupClickTransFormers())
                .subscribe(unit -> {
            Utils.showToast(RxBindingTest1Act.this,"Button防止重复点击");
        });*/
    }



}
