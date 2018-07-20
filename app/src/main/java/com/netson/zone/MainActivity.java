package com.netson.zone;

import com.netson.business.presenter.IRegisterPresenter;
import com.netson.business.presenterimp.RegisterPresenter;
import com.netson.business.view.IRegisterView;
import com.netson.commonmodule.bean.RegisterRsp;
import com.netson.commonmodule.mvp.BaseActivity;
import com.netson.commonmodule.utils.ToastUtils;

public class MainActivity extends BaseActivity<IRegisterView, IRegisterPresenter> implements IRegisterView {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public IRegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public IRegisterView createView() {
        return this;
    }

    @Override
    public void init() {
        getPresenter().onRegister("曾强", "123456");
    }

    @Override
    public void onRegisterSuceess(RegisterRsp rsp) {
        ToastUtils.toastLongMessage(rsp.uuid);
    }

    @Override
    public void onRegisterFail(RegisterRsp rsp) {
        ToastUtils.toastLongMessage(rsp.err_msg);
    }
}
