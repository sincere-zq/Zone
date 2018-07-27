package com.netson.commonmodule.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultiItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    private int itemType;
    public String content;

    public MultiItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
