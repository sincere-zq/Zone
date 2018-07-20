package com.netson.commonmodule.adpter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.netson.commonmodule.R;

public class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        TextView tv_desc = baseViewHolder.getView(R.id.tv_desc);
        tv_desc.setText(s);
    }
}
