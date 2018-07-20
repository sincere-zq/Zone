package com.netson.zone.ui;

import android.content.Intent;
import android.widget.EditText;

import com.netson.business.presenter.ILoginPresenter;
import com.netson.business.presenterimp.LoginPresenter;
import com.netson.business.view.ILoginView;
import com.netson.commonmodule.mvp.BaseActivity;
import com.netson.commonmodule.utils.ToastUtils;
import com.netson.zone.R;
import com.netson.zone.widget.TitleBar;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILoginView, ILoginPresenter> implements ILoginView {

    @BindView(R.id.login_title)
    TitleBar loginTitle;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public ILoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public ILoginView createView() {
        return this;
    }

    @Override
    public void init() {
        loginTitle.setTitle(R.string.login_title);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String phone = etUserName.getText().toString();
        String pwd = etPwd.getText().toString();
        if (getPresenter().checkInputEmpty(phone, pwd)) {
            getPresenter().login(phone, pwd);
        }
    }

    @Override
    public void onLoginSuccess() {
        ToastUtils.toastShortMessage(R.string.login_success);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
