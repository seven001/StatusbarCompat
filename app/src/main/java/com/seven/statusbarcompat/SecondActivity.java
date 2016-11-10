package com.seven.statusbarcompat;

import android.os.Bundle;

import com.seven.statusbarcompat.utils.BaseActivity;

/**
 * 沉浸式2页面
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setTitle("这是沉浸式2");
    }
}
