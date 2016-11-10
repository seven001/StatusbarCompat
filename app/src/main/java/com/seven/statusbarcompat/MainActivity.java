package com.seven.statusbarcompat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.seven.statusbarcompat.utils.BaseToActivity;

/**
 * 首页
 */
public class MainActivity extends BaseToActivity {

    private ViewPager vp_main;
    private MyAdapter MyAdapter;
    public LeftFragment LeftFragment;
    public RightFragment RightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        MyAdapter = new MyAdapter();
        vp_main.setAdapter(MyAdapter);
        vp_main.addOnPageChangeListener(PagerListener);
    }

    /**
     * 页面切换
     */
    ViewPager.OnPageChangeListener PagerListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            vp_main.setCurrentItem(arg0);
        }

    };

    // 添加适配器
    public class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (LeftFragment == null) {
                        return LeftFragment = new LeftFragment();
                    }
                    break;
                case 1:
                    if (RightFragment == null) {
                        return RightFragment = new RightFragment();
                    }
                    break;
            }
            return null;

        }
    }
}
