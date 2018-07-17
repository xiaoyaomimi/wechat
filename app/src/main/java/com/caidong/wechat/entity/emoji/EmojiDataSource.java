package com.caidong.wechat.entity.emoji;

import java.util.List;


public class EmojiDataSource {

    private int emojiType;

    public int getEmojiType() {
        return emojiType;
    }

    public void setEmojiType(int emojiType) {
        this.emojiType = emojiType;
    }

    public List<EmojiBean> getEmojiList() {
        return emojiList;
    }

    public void setEmojiList(List<EmojiBean> emojiList) {
        this.emojiList = emojiList;
    }

    private List<EmojiBean> emojiList;

}
