package com.caidong.wechat.entity;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

public class PraiseBean {
    private String praiseUserName;
    private String praiseUserId;

    public String getPraiseUserName() {
        return praiseUserName;
    }

    public void setPraiseUserName(String praiseUserName) {
        this.praiseUserName = praiseUserName;
    }

    public String getPraiseUserId() {
        return praiseUserId;
    }

    public void setPraiseUserId(String praiseUserId) {
        this.praiseUserId = praiseUserId;
    }
}
