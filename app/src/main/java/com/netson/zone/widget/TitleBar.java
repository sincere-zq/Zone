package com.netson.zone.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.netson.zone.R;

public class TitleBar extends RelativeLayout implements View.OnClickListener {
    private ImageView img_back;
    private TextView tv_title;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_title_bar, null);
        img_back = view.findViewById(R.id.img_back);
        tv_title = view.findViewById(R.id.tv_title);
        img_back.setOnClickListener(this);
        view.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(view);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            onBack();
        }
    }

    private void onBack() {
        try {
            ((Activity) getContext()).onBackPressed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        tv_title.setText(title);
    }

    public void setTitle(int resId) {
        tv_title.setText(resId);
    }
}
