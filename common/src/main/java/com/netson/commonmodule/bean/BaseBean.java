package com.netson.commonmodule.bean;

public class BaseBean<T> {
    public int ret;
    public T data;
    public String msg;

    @Override
    public String toString() {
        return "BaseBean{" +
                "ret=" + ret +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
