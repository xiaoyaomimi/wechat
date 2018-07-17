package com.caidong.wechat.ui.fragment.index;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.caidong.wechat.R;
import com.caidong.wechat.entity.Live;
import com.caidong.wechat.ui.adapter.LiveAdapter;
import com.caidong.wechat.ui.adapter.decoration.SpaceItemDecoration;
import com.caidong.wechat.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caidong on 2018/7/17.
 * email:mircaidong@163.com
 * describe: 描述
 */
public class LiveFragment extends BaseFragment {
    private RecyclerView rvLive;
    private LiveAdapter adapter;
    private List<Live> list;

    @Override
    public View initView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_live, null);
        return view;
    }

    @Override
    public void initData() {
        rvLive = view.findViewById(R.id.rv_live);
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Live());
        }
        adapter = new LiveAdapter(list);
        rvLive.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvLive.addItemDecoration(new SpaceItemDecoration(getActivity(),1));
        rvLive.setAdapter(adapter);
    }
}
