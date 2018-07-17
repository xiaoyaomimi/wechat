package com.caidong.wechat.ui.adapter.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by caidong on 2018/4/13.
 * email:mircaidong@163.com
 * describe: 描述
 */

public class SpaceItemDecorationH extends RecyclerView.ItemDecoration {

    private int mSpace;

    public SpaceItemDecorationH(Context context, int dpValue) {
        mSpace = dp2px(context,dpValue);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildAdapterPosition(view) > 0) {
            //从第二个条目开始，距离上方Item的距离
            outRect.left = mSpace;
        }
    }

    /**
     * dp to px转换
     * @param context
     * @param dpValue
     * @return
     */
    private int dp2px(Context context,int dpValue){
        int pxValue = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
        return pxValue;
    }
}
