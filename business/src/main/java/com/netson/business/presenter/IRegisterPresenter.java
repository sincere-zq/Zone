package com.netson.business.presenter;

import com.netson.business.view.IRegisterView;
import com.netson.commonmodule.mvp.BasePresenter;

public abstract class IRegisterPresenter extends BasePresenter<IRegisterView> {
    public abstract void onRegister(String username, String password);
}
