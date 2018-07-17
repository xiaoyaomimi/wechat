package com.caidong.wechat.ui.adapter;

import android.support.annotation.Nullable;

import com.caidong.wechat.R;
import com.caidong.wechat.entity.Live;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by caidong on 2018/7/17.
 * email:mircaidong@163.com
 * describe: 描述
 */
public class VideoAdapter extends BaseQuickAdapter<Live,BaseViewHolder> {

    public VideoAdapter(@Nullable List<Live> data) {
        super(R.layout.list_item_video,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Live item) {

    }
}
