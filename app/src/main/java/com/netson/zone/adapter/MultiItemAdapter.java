package com.netson.zone.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.netson.commonmodule.bean.MultiItem;
import com.netson.commonmodule.widget.CircleImageView;
import com.netson.zone.R;

import java.util.List;

public class MultiItemAdapter extends BaseMultiItemQuickAdapter<MultiItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultiItemAdapter(List<MultiItem> data) {
        super(data);
        addItemType(MultiItem.TEXT, R.layout.item_text);
        addItemType(MultiItem.IMG, R.layout.item_img);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItem item) {
        switch (helper.getItemViewType()) {
            case MultiItem.TEXT:
                helper.setText(R.id.tv_text, item.content);
                break;
            case MultiItem.IMG:
                CircleImageView circleImageView = helper.getView(R.id.img_circle);
                circleImageView.loadImage(item.content);
                break;
        }
    }
}
