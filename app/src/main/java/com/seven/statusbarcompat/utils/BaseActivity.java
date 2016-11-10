package com.seven.statusbarcompat.utils;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.seven.statusbarcompat.R;

/**
 * Activity基类
 * Created by zg on 2016/9/22.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置无标题栏
        StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.blue));
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title){
        ((TextView)findViewById(R.id.tv_head_title)).setText(title);
    }

    /**
     * 返回
     */
    public void doBack(View view) {
        finish();
    }
}

