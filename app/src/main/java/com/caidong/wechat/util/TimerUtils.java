package com.caidong.wechat.util;

import android.annotation.SuppressLint;


import com.caidong.wechat.util.interfaces.OnTimerResultListener;
import java.util.concurrent.TimeUnit;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class TimerUtils {
    @SuppressLint("CheckResult")
    public static void timerTranslation(OnTimerResultListener onTimerResultListener) {
        Single.timer(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread()).subscribe(aLong -> {
            if (onTimerResultListener != null) {
                onTimerResultListener.onTimerResult();
            }
        });
    }
}
