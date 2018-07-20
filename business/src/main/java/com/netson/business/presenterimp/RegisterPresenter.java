package com.netson.business.presenterimp;

import com.netson.business.presenter.IRegisterPresenter;
import com.netson.commonmodule.bean.RegisterRsp;
import com.netson.commonmodule.common.ParamsHelper;
import com.netson.commonmodule.common.Request;
import com.netson.commonmodule.progress.ObserverResponseListener;
import com.netson.commonmodule.utils.ToastUtils;

public class RegisterPresenter extends IRegisterPresenter {
    @Override
    public void onRegister(String username, String password) {
        Request.register(
                ParamsHelper.register(username, password),
                getContext(),
                getTransformer(),
                new ObserverResponseListener<RegisterRsp>() {
                    @Override
                    public void onNext(RegisterRsp registerRsp) {
                        if (getView() != null) {
                            switch (registerRsp.err_code) {
                                case 0:
                                    getView().onRegisterSuceess(registerRsp);
                                    break;
                                default:
                                    getView().onRegisterFail(registerRsp);
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.toastShortMessage(e.getMessage().toString());
                    }
                });
    }
}
