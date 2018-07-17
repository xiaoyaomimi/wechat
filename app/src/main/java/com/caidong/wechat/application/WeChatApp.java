package com.caidong.wechat.application;

import android.app.Application;
import android.content.Context;

import com.caidong.wechat.others.DataCenter;

/**
 * Created by caidong on 2018/7/17.
 * email:mircaidong@163.com
 * describe: 描述
 */
public class WeChatApp extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        DataCenter.init();
    }
}
