package com.caidong.wechat.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by caidong on 2018/4/20.
 * email:mircaidong@163.com
 * describe: 描述
 */
public abstract class BaseFragment extends Fragment {
    public View view;
    private boolean isVisible = false;
    private boolean isPrepared = false;
    private boolean isFirst = true;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null)
            view = initView(inflater);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    /**
     * 懒加载
     */
    private void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        if (isFirst) {
            initData();
            isFirst = false;
        }
    }


    //拿到布局填充器去填充相应的xml,生成指定的view对象
    public abstract View initView(LayoutInflater inflater);

    //view填充数据的操作
    public abstract void initData();
}
