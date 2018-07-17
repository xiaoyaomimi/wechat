package com.caidong.wechat.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.caidong.wechat.R;
import com.caidong.wechat.ui.adapter.ViewPagerFragmentAdapter;
import com.caidong.wechat.ui.fragment.FriendFragment;
import com.caidong.wechat.ui.fragment.IndexFragment;
import com.caidong.wechat.ui.fragment.MessageFragment;
import com.caidong.wechat.ui.fragment.MineFragment;
import com.caidong.wechat.ui.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caidong on 2018/7/17.
 * email:mircaidong@163.com
 * describe: 描述
 */
public class MainActivity extends BaseFragmentActivity implements CompoundButton.OnCheckedChangeListener {
    private List<Fragment> fragmentList;
    private ViewPagerFragmentAdapter adapter;
    private IndexFragment indexFragment;
    private CustomViewPager viewPager;
    private RadioButton indexRb;
    private RadioButton friendRb;
    private RadioButton messageRb;
    private RadioButton mineRb;

    @Override
    public void initView() {
        //绑定视图
        bindView();
        initObjectAndEvent();
    }

    /**
     * 绑定视图
     */
    private void bindView(){
        viewPager = findViewById(R.id.main_view_pager);
        indexRb = findViewById(R.id.index_rb);
        friendRb = findViewById(R.id.friend_rb);
        messageRb = findViewById(R.id.message_rb);
        mineRb = findViewById(R.id.mine_rb);
    }

    /**
     * 初始化事件和变量
     */
    private void initObjectAndEvent(){
        fragmentList = new ArrayList<>();
        indexFragment = new IndexFragment();
        fragmentList.add(indexFragment);
        fragmentList.add(new FriendFragment());
        fragmentList.add(new MessageFragment());
        fragmentList.add(new MineFragment());
        adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setScanScroll(false);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        indexRb.setChecked(true);
                        break;
                    case 1:
                        friendRb.setChecked(true);
                        break;
                    case 2:
                        messageRb.setChecked(true);
                        break;
                    case 3:
                        mineRb.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        indexRb.setOnCheckedChangeListener(this);
        friendRb.setOnCheckedChangeListener(this);
        messageRb.setOnCheckedChangeListener(this);
        mineRb.setOnCheckedChangeListener(this);
        indexRb.setChecked(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.index_rb:
                if (isChecked)
                    viewPager.setCurrentItem(0);
                break;
            case R.id.friend_rb:
                if (isChecked)
                    viewPager.setCurrentItem(1);
                break;
            case R.id.message_rb:
                if (isChecked)
                    viewPager.setCurrentItem(2);
                break;
            case R.id.mine_rb:
                if (isChecked)
                    viewPager.setCurrentItem(3);
                break;
        }
    }
}
