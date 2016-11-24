package com.wl.ui.androidui.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.adapter.MainAdapter;
import com.wl.ui.androidui.recycleview.entity.MainItem;
import com.wl.ui.baselib.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by wangliang on 16-11-18.
 */

public class RecycleMainActivity extends BaseActivity {

    private RecyclerView mRv;
    private List<MainItem> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_main);

        initActionBarWithBack("RecycleView Demo");
        mRv = ButterKnife.findById(this, R.id.rv_list);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        initData();
        BaseQuickAdapter adapter = new MainAdapter(R.layout.recycle_main_item_view, mList);
        adapter.openLoadAnimation();
        mRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
                Intent intent = new Intent(RecycleMainActivity.this, mList.get(position).getClazz());
                startActivity(intent);
            }
        });
        mRv.setAdapter(adapter);
    }

    private void initData() {
        MainItem item = new MainItem();
        item.setContent("普通纵向List");
        item.setClazz(RecycleVerticalListActivity.class);
        mList.add(item);

        item = new MainItem();
        item.setContent("普通横向List");
        item.setClazz(RecycleHorListActivity.class);
        mList.add(item);

        item = new MainItem();
        item.setContent("Grid");
        item.setClazz(RecycleGridActivity.class);
        mList.add(item);

        item = new MainItem();
        item.setContent("复杂布局");
        item.setClazz(RecycleMultiActivity.class);
        mList.add(item);
    }


}
