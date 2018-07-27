package com.netson.zone.ui;

import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.netson.business.presenter.IRegisterPresenter;
import com.netson.business.presenterimp.RegisterPresenter;
import com.netson.business.view.IRegisterView;
import com.netson.commonmodule.bean.RegisterRsp;
import com.netson.commonmodule.mvp.BaseActivity;
import com.netson.commonmodule.utils.ToastUtils;
import com.netson.zone.R;
import com.netson.zone.client.JsWebClient;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IRegisterView, IRegisterPresenter> implements IRegisterView {

    @BindView(R.id.webView)
    WebView webView;

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
//        getPresenter().onRegister("曾强", "123456");
        initWebView();
    }

    @Override
    public void onRegisterSuceess(RegisterRsp rsp) {
        ToastUtils.toastLongMessage(rsp.uuid);
    }

    @Override
    public void onRegisterFail(RegisterRsp rsp) {
        ToastUtils.toastLongMessage(rsp.err_msg);
    }

    @OnClick(R.id.btn_clear)
    public void onViewClicked() {
        startActivity(new Intent(this, MultiActivity.class));
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 先加载JS代码
        webView.loadUrl("file:///android_asset/js.html");
        webView.setWebChromeClient(new JsWebClient());

    }
}
