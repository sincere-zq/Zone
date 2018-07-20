package com.netson.commonmodule.api;

/**
 * Created by 曾强 on 2018/6/5.
 */

public class Api {
    private String baseUrl = "http://api.okayapi.com/";
    private volatile static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }

    private Api() {
        BaseApi baseApi = new BaseApi();
        apiService = baseApi.getRetrofit(baseUrl).create(ApiService.class);
    }
}
