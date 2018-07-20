package com.netson.commonmodule.bean;

import java.io.Serializable;

public class RegisterRsp implements Serializable {
    public int err_code;
    public String err_msg;
    public String uuid;

    @Override
    public String toString() {
        return "RegisterRsp{" +
                "err_code=" + err_code +
                ", err_msg='" + err_msg + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
