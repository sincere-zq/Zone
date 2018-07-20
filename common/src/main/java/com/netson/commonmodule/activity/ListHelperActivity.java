package com.netson.commonmodule.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ajguan.library.EasyRefreshLayout;
import com.ajguan.library.LoadModel;
import com.netson.commonmodule.R;
import com.netson.commonmodule.adpter.MyAdapter;
import com.netson.commonmodule.widget.RefreshView;

import java.util.ArrayList;
import java.util.List;

public class ListHelperActivity extends AppCompatActivity implements EasyRefreshLayout.EasyEvent {
    RefreshView refresh;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_helper);
        init();
        adapter.addData(getDatas());
    }

    private void init() {
        refresh = findViewById(R.id.refresh);
        refresh.setLinearLayoutManager();
        adapter = new MyAdapter(R.layout.item_test);
        TextView textView = new TextView(this);
        textView.setText("Header");
        adapter.setHeaderView(textView);
        refresh.setAdapter(adapter);
        refresh.addEasyEvent(this);
        refresh.setLoadMoreModel(LoadModel.ADVANCE_MODEL);
    }


    private List<String> getDatas() {
        int length = adapter.getData().size();
        Log.e("length", length + "");
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            datas.add("item" + (i + length));
        }
        return datas;
    }

    @Override
    public void onLoadMore() {
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addData(getDatas());
                refresh.loadMoreComplete();
            }
        }, 2000);
    }

    @Override
    public void onRefreshing() {
        refresh.setRefreshing(true);
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setNewData(getDatas());
                refresh.refreshComplete();
            }
        }, 2000);
    }
}
