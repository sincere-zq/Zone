package com.netson.commonmodule.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.netson.commonmodule.R;
import com.netson.commonmodule.tools.AppManager;
import com.netson.commonmodule.tools.SystemStatusManager;
import com.netson.commonmodule.utils.NetworkUtils;
import com.netson.commonmodule.utils.ToastUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;

import java.util.List;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Description: Activity基类
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    protected boolean useDefaultTitleBarColor;//状态栏颜色是否使用默认颜色

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initBase();
        beforeInitView();
        if (useDefaultTitleBarColor) {
            //改变状态栏颜色;注意：此处一旦设置 android:fitsSystemWindows="false"将无效
            setTitleBarColor(R.color.colorPrimaryDark);
        }
        initData();
        setListener();
    }

    /**
     * 通用的一些基本设置
     */
    private void initBase() {
        //注解实现view的绑定
        ButterKnife.bind(this);

        //如果存在actionBar，就隐藏(也可以通过主题AppTheme.NoActionBar隐藏)
//        if (getSupportActionBar() != null)
//            getSupportActionBar().hide();

        //将新建的activity添加到stack里进行管理
        AppManager.getInstance().addActivity(this);

        //设置状态栏透明
        setTranslucentStatus();

        useDefaultTitleBarColor = true;

    }

    /**
     * 线程调度
     */
    public <T> ObservableTransformer<T, T> compose(final LifecycleTransformer<T> lifecycle) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        // 可添加网络连接判断等
                        if (!NetworkUtils.isNetAvailable(BaseActivity.this)) {
                            ToastUtils.toastShortMessage("网络已断开");
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).compose(lifecycle);
            }
        };
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        //此处activity被杀死可以保存数据
        super.onSaveInstanceState(outState, outPersistentState);
    }

    protected abstract int getContentViewId();//放layoutId

    protected void beforeInitView() {

    }//初始化View之前做的事

    protected abstract void initData();//初始化数据

    protected abstract void setListener();//设置事件

    /**
     * 状态栏透明只有Android 4.4 以上才支持
     */
    protected void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.setAttributes(layoutParams);
        }
    }

    /**
     * 设置状态栏背景颜色
     */
    protected void setTitleBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        }
        SystemStatusManager tintManager = new SystemStatusManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
    }


    /**
     * 本段代码用来处理如果输入法还显示的话就消失掉输入键盘
     */
    protected void dismissSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示键盘
     *
     * @param view
     */
    protected void showKeyboard(View view) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * [页面跳转]
     */
    protected void openActivity(Class<?> clz) {
        openActivity(clz, null);
    }

    /**
     * [携带数据的页面跳转]
     */
    protected void openActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Request permissions.
     */
    protected void requestPermission(String... permissions) {
        AndPermission.with(this)
                .runtime()
                .permission(permissions)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> permissions) {
                        onRequestPermissionGranted(permissions);
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        onRequestPermissionDenied(permissions);
                    }
                })
                .start();
    }

    /**
     * 申请权限成功
     */
    protected void onRequestPermissionGranted(@NonNull List<String> permissions) {

    }

    /**
     * 申请权限失败
     */
    protected void onRequestPermissionDenied(@NonNull List<String> permissions) {

    }


    @Override
    protected void onDestroy() {
        AppManager.getInstance().remove(this);
        //注：unregister官方是放入到onStop方法中，真实开发一般是放入onDestroy即当被销毁才取消注册
//        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
