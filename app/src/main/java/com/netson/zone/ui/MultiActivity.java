package com.netson.zone.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.netson.business.presenter.IMulitiPresenter;
import com.netson.business.presenterimp.MulitiPresenter;
import com.netson.business.view.IMultiView;
import com.netson.commonmodule.bean.MultiItem;
import com.netson.commonmodule.mvp.BaseActivity;
import com.netson.zone.R;
import com.netson.zone.adapter.MultiItemAdapter;

import java.util.List;

import butterknife.BindView;

public class MultiActivity extends BaseActivity<IMultiView, IMulitiPresenter> implements IMultiView {

    @BindView(R.id.multiList)
    RecyclerView multiList;
    MultiItemAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_multi;
    }

    @Override
    public IMulitiPresenter createPresenter() {
        return new MulitiPresenter();
    }

    @Override
    public IMultiView createView() {
        return this;
    }

    @Override
    public void init() {
        multiList.setLayoutManager(new GridLayoutManager(this, 2));
        getPresenter().getMulitiData();
    }

    @Override
    public void showData(List<MultiItem> items) {
        adapter = new MultiItemAdapter(items);
        multiList.setAdapter(adapter);
    }
}
