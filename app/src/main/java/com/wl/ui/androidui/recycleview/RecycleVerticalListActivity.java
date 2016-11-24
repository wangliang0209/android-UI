package com.wl.ui.androidui.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.adapter.VerticalAdapter;
import com.wl.ui.androidui.recycleview.entity.VerticalItem;
import com.wl.ui.baselib.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by wangliang on 16-11-23.
 */

public class RecycleVerticalListActivity extends BaseActivity {

    private RecyclerView mRv;
    private List<VerticalItem> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_vertical_list);
        initActionBarWithBack("纵向Recycle List Demo");
        mRv = ButterKnife.findById(this, R.id.rv_list);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        initData();
        BaseQuickAdapter adapter = new VerticalAdapter(R.layout.recycle_vertical_item_view, mList);
        adapter.openLoadAnimation();
        mRv.setAdapter(adapter);

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            VerticalItem item = new VerticalItem();
            item.setText("item:" + (i + 1));
            item.setUrl("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
            mList.add(item);
        }
    }
}
