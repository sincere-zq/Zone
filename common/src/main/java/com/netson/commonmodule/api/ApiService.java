package com.netson.commonmodule.api;

import com.netson.commonmodule.bean.BaseBean;
import com.netson.commonmodule.bean.RegisterRsp;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 曾强 on 2018/6/5.
 */

public interface ApiService {
    /**
     * 注册
     *
     * @return
     */
    @POST(UrlConst.REGISTER)
    Observable<BaseBean<RegisterRsp>> register(@QueryMap Map<String, String> params);

}
