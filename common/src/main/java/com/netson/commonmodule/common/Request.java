package com.netson.commonmodule.common;

import android.content.Context;

import com.netson.commonmodule.api.Api;
import com.netson.commonmodule.bean.RegisterRsp;
import com.netson.commonmodule.progress.ObserverResponseListener;

import java.util.Map;

import io.reactivex.ObservableTransformer;

/**
 * Created by 曾强 on 2018/6/6.
 * 数据请求列表
 */

public class Request extends BaseModel {
    /**
     * 注册
     *
     * @param params
     * @param context
     * @param transformer
     * @param listener
     */
    public static void register(Map<String, String> params,
                                Context context,
                                ObservableTransformer transformer,
                                ObserverResponseListener<RegisterRsp> listener) {
        subscribe(context, Api.getApiService().register(params), listener, transformer);
    }

}
