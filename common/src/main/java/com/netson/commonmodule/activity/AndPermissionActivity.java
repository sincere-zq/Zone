package com.netson.commonmodule.activity;

import android.view.View;

import com.netson.commonmodule.R;
import com.netson.commonmodule.common.BaseActivity;
import com.netson.commonmodule.utils.ToastUtils;
import com.yanzhenjie.permission.Permission;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class AndPermissionActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_and_permission;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    public void requestPermission(View view) {
        requestPermission(Permission.CAMERA);
    }

    @Override
    protected void onRequestPermissionGranted(@NonNull List<String> permissions) {
        super.onRequestPermissionGranted(permissions);
        ToastUtils.toastLongMessage("申请成功");
    }

    @Override
    protected void onRequestPermissionDenied(@NonNull List<String> permissions) {
        super.onRequestPermissionDenied(permissions);
        ToastUtils.toastLongMessage("申请失败");
    }
}
