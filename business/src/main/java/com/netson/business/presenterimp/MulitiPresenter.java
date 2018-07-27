package com.netson.business.presenterimp;

import com.netson.business.presenter.IMulitiPresenter;
import com.netson.commonmodule.bean.MultiItem;

import java.util.ArrayList;
import java.util.List;

public class MulitiPresenter extends IMulitiPresenter {
    @Override
    public void getMulitiData() {
        List<MultiItem> multiItems = new ArrayList<>();
        MultiItem multiItem;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                multiItem = new MultiItem(MultiItem.TEXT);
                multiItem.content = "item " + i;
            } else {
                multiItem = new MultiItem(MultiItem.IMG);
                multiItem.content = "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2239241582,2069209434&fm=58&bpow=760&bpoh=760";
            }
            multiItems.add(multiItem);
        }
        getView().showData(multiItems);
    }
}
