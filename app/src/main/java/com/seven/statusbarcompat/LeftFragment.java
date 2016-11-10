package com.seven.statusbarcompat;

import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.seven.statusbarcompat.utils.BaseFragment;
import com.seven.statusbarcompat.utils.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zg on 2016/7/15.
 * left-frm
 */
//<!--输入法与沉浸式冲突见AndroidManifest.xml-->
public class LeftFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();
    private HomeAdapter mAdapter;
    private int totalDy = 0;
    //例如轮播图高1000，titleBar的高是200，需要移动的距离就是1000-200=800
    private final static int distance = -550;//移动的目标距离
    private RelativeLayout re_left_change;

    @Override
    protected int setViewId() {
        return R.layout.fragment_left;
    }

    @Override
    protected void onCreateViews(View view) {
        setTitle(view, "这是模仿qq空间");
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        re_left_change = (RelativeLayout) view.findViewById(R.id.re_left_change);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2)// 沉浸式
        {
            re_left_change.setPadding(0, StatusBarCompat.getStatusBarHeight(getActivity()), 0, 0);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initDatas();
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(getActivity(), mDatas));
    }

    private void initDatas() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                totalDy -= dy;
                float alpha = (totalDy * 1.0f / distance * 1.0f) * 255;
                if (alpha >= 255) {
                    alpha = 255;
                } else if (alpha <= 0) {
                    alpha = 0;
                }
                re_left_change.getBackground().setAlpha((int) alpha);
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
