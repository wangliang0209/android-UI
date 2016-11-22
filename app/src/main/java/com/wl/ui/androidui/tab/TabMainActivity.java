package com.wl.ui.androidui.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.wl.ui.androidui.R;
import com.wl.ui.baselib.BaseActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangliang on 16-11-18.
 */

public class TabMainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_example);

        initActionBarWithBack("Tab Demo");

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        final MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ExampleFragment(), "first");
        adapter.addFragment(new ExampleFragment(), "second");
        adapter.addFragment(new ExampleFragment(), "third");
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments = new LinkedList<>();
        private List<String> mTitles = new LinkedList<>();

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
