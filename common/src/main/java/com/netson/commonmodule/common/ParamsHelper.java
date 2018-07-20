package com.netson.commonmodule.common;

import com.netson.commonmodule.api.UrlConst;
import com.netson.commonmodule.utils.MD5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 曾强 on 2018/6/6.
 * 参数工具
 */

public class ParamsHelper {
    /**
     * 注册
     */
    public static Map<String, String> register(String username, String pwd) {
        Map<String, String> params = getMap();
        params.put("username", username);
        params.put("password", MD5.getStringMD5(pwd));
        return params;
    }

    /**
     * 登录
     */
    public static Map<String, String> login(String username, String pwd) {
        Map<String, String> params = getMap();
        params.put("username", username);
        params.put("password", MD5.getStringMD5(pwd));
        return params;
    }


    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("app_key", UrlConst.APP_KEY);
        return map;
    }
}
