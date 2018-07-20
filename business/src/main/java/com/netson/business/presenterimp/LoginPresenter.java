package com.netson.business.presenterimp;

import android.os.Handler;
import android.text.TextUtils;

import com.netson.business.R;
import com.netson.business.presenter.ILoginPresenter;
import com.netson.commonmodule.bean.User;
import com.netson.commonmodule.utils.DialogMaker;
import com.netson.commonmodule.utils.PreferensesUtils;
import com.netson.commonmodule.utils.ToastUtils;

public class LoginPresenter extends ILoginPresenter {
    /**
     * 检查为空
     *
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public boolean checkInputEmpty(String phone, String pwd) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.toastShortMessage(R.string.phone_is_empty);
            return false;
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.toastShortMessage(R.string.pwd_is_empty);
            return false;
        }
        return true;
    }

    /***
     * 登录
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public void login(final String phone, final String pwd) {
        DialogMaker.showProgressDialog(getContext(), "正在加载...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DialogMaker.dismissProgressDialog();
                if (getView() != null) {
                    User user = new User();
                    user.phone = "phone";
                    user.pwd = pwd;
                    PreferensesUtils.saveUser(user);
                    getView().onLoginSuccess();
                }
            }
        }, 2000);
    }
}
