package com.netson.business.presenter;

import com.netson.business.view.ILoginView;
import com.netson.commonmodule.mvp.BasePresenter;

public abstract class ILoginPresenter extends BasePresenter<ILoginView> {
    public abstract boolean checkInputEmpty(String phone, String pwd);

    public abstract void login(String phone, String pwd);
}
