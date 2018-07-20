package com.netson.business.view;

import com.netson.commonmodule.bean.RegisterRsp;
import com.netson.commonmodule.mvp.BaseView;

public interface IRegisterView extends BaseView {
    void onRegisterSuceess(RegisterRsp rsp);

    void onRegisterFail(RegisterRsp rsp);
}
