package com.netson.business.view;

import com.netson.commonmodule.bean.MultiItem;
import com.netson.commonmodule.mvp.BaseView;

import java.util.List;

public interface IMultiView extends BaseView {
    void showData(List<MultiItem> items);
}
