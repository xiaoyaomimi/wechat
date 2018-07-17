package com.caidong.wechat.ui.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.caidong.wechat.R;
import com.caidong.wechat.ui.adapter.CustomPagerAdapter;
import com.caidong.wechat.ui.fragment.index.LiveFragment;
import com.caidong.wechat.ui.fragment.index.MomentFragment;
import com.caidong.wechat.ui.fragment.index.VideoFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by caidong on 2018/7/17.
 * email:mircaidong@163.com
 * describe: 描述
 */
public class IndexFragment extends BaseFragment {
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private CustomPagerAdapter adapter;
    private TabLayout tabLayout;
    private List<String> titles = Arrays.asList("视频", "直播", "图文");

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_index, null);
        return view;
    }

    @Override
    public void initData() {
        bindView();
        fragmentList = new ArrayList<>();
        fragmentList.add(new VideoFragment());
        fragmentList.add(new LiveFragment());
        fragmentList.add(new MomentFragment());
        adapter = new CustomPagerAdapter(getFragmentManager(), titles, fragmentList);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < titles.size(); i++){
            TextView textView = new TextView(getActivity());
            textView.setText(titles.get(i));
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(lp);
            if (i == 0){
                textView.setTextSize(20f);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }
            tabLayout.addTab(tabLayout.newTab().setCustomView(textView));
        }
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(20f);
                    ((TextView) view).setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(16f);
                    ((TextView) view).setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                View view = tab.getCustomView();
                if (null != view && view instanceof TextView) {
                    ((TextView) view).setTextSize(16f);
                }
            }
        });
    }

    private void bindView() {
        viewPager = view.findViewById(R.id.index_vp);
        tabLayout = view.findViewById(R.id.index_tablayout);
    }
}
