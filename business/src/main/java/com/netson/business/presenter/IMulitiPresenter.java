package com.netson.business.presenter;

import com.netson.business.view.IMultiView;
import com.netson.commonmodule.mvp.BasePresenter;

public abstract class IMulitiPresenter extends BasePresenter<IMultiView> {
    public abstract void getMulitiData();
}
