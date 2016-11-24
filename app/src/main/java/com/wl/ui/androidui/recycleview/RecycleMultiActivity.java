package com.wl.ui.androidui.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.adapter.MultipleItemQuickAdapter;
import com.wl.ui.androidui.recycleview.entity.ImgMultipleItem;
import com.wl.ui.androidui.recycleview.entity.MultipleItem;
import com.wl.ui.androidui.recycleview.entity.TxtMultipleItem;
import com.wl.ui.baselib.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by wangliang on 16-11-23.
 */

public class RecycleMultiActivity extends BaseActivity {

    private RecyclerView mRv;
    private List<MultipleItem> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_vertical_list);
        initActionBarWithBack("复杂布局 List Demo");
        mRv = ButterKnife.findById(this, R.id.rv_list);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        initData();
        BaseQuickAdapter adapter = new MultipleItemQuickAdapter(this, mList);
        adapter.openLoadAnimation();
        mRv.setAdapter(adapter);

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0) {
                TxtMultipleItem item = new TxtMultipleItem("我是文本类型");
                mList.add(item);
            } else {
                ImgMultipleItem item = new ImgMultipleItem("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
                mList.add(item);
            }
        }
    }
}
