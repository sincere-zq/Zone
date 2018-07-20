package com.netson.commonmodule.utils;

import com.netson.commonmodule.bean.User;
import com.netson.commonmodule.tools.Preferences;

public class PreferensesUtils extends Preferences {
    private static final String PHONE = "phone";//电话
    private static final String PWD = "password";//密码
    private static final String USER = "user";//用户信息

    /**
     * 清理
     */
    public static void clear() {
        clean();
    }

    /**
     * 保存电话
     *
     * @param phone
     */
    public static void savePhone(String phone) {
        saveString(PHONE, phone);
    }

    /**
     * 获取电话
     *
     * @return
     */
    public static String getPhone() {
        return getString(PHONE);
    }

    /**
     * 保存密码
     *
     * @param pwd
     */
    public static void savePwd(String pwd) {
        saveString(PWD, pwd);
    }

    /**
     * 获取密码
     *
     * @return
     */
    public static String getPwd() {
        return getString(PWD);
    }

    /**
     * 保存用户信息
     *
     * @param user
     */
    public static void saveUser(User user) {
        saveObj(USER, user);
    }

    /**
     * 获取缓存的用户信息
     *
     * @return
     */
    public static User getUser() {
        return getObj(USER, User.class);
    }
}
