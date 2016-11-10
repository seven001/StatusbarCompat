package com.seven.statusbarcompat.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.seven.statusbarcompat.R;

/**
 * Activity基类（透明沉浸式）
 * Created by zg on 2016/9/22.
 */
public class BaseToActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题栏
        StatusBarCompat.transparent(this);
    }

    /**
     * 返回
     */
    public void doBack(View view) {
        finish();
    }
}

