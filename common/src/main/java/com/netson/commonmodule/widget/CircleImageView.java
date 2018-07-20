package com.netson.commonmodule.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.bumptech.glide.Glide;
import com.netson.commonmodule.R;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * 圆形图片
 */
public class CircleImageView extends AppCompatImageView {
    private static final int placeholderId = R.drawable.ic_launcher_background;
    private static final int errorId = R.mipmap.ic_launcher_round;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void loadImage(String url) {
        Glide.with(getContext())
                .load(url)
                .centerCrop()
                .placeholder(placeholderId)
                .crossFade()
                .error(errorId)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(this);
    }

    public void loadImage(int resId) {
        Glide.with(getContext())
                .load(resId)
                .centerCrop()
                .placeholder(placeholderId)
                .crossFade()
                .error(errorId)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(this);
    }
}
