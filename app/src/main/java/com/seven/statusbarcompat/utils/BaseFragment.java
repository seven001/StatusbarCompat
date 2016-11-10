package com.seven.statusbarcompat.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seven.statusbarcompat.R;

/**
 * Fragment基类
 * Created by 2016/9/22.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setViewId(),container,false);
        onCreateViews(view);
        return view;
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(View view, String title){
        ((TextView)view.findViewById(R.id.tv_head_title)).setText(title);
    }

    /**
     * 布局文件id
     * @return
     */
    protected abstract int setViewId();

    protected abstract void onCreateViews(View view);
}
