package com.netson.commonmodule.bean;

import java.io.Serializable;

public class User implements Serializable {
    public String pwd;
    public String phone;

    @Override
    public String toString() {
        return "User{" +
                "pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
