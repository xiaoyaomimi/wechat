package com.caidong.wechat.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by caidong on 2018/7/17.
 * email:mircaidong@163.com
 * describe: 描述
 */
public class CustomPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> titles;

    public CustomPagerAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragmentList) {
        super(fm);
        list = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
