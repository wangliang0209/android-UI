package com.wl.ui.androidui.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.adapter.GridAdapter;
import com.wl.ui.androidui.recycleview.entity.GridItem;
import com.wl.ui.baselib.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by wangliang on 16-11-23.
 */

public class RecycleGridActivity extends BaseActivity {

    private RecyclerView mRv;
    private Button mChangeOrientation;
    private List<GridItem> mList = new ArrayList<>();

    private boolean isVertical = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_grid_list);
        initActionBarWithBack("Recycle Grid Demo");
        mRv = ButterKnife.findById(this, R.id.rv_list);

        mChangeOrientation = ButterKnife.findById(this, R.id.change_orientation);
        mChangeOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isVertical = ! isVertical;
                if(isVertical) {
                    mChangeOrientation.setText("纵向");
                    GridLayoutManager layoutManager = new GridLayoutManager(RecycleGridActivity.this, 4, LinearLayoutManager.VERTICAL, false);
                    mRv.setLayoutManager(layoutManager);
                } else {
                    mChangeOrientation.setText("横向");
                    GridLayoutManager layoutManager = new GridLayoutManager(RecycleGridActivity.this, 4, LinearLayoutManager.HORIZONTAL, false);
                    mRv.setLayoutManager(layoutManager);
                }
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(layoutManager);
        initData();
        BaseQuickAdapter adapter = new GridAdapter(this, R.layout.recycle_grid_item_view, mList);
        adapter.openLoadAnimation();
        mRv.setAdapter(adapter);

    }

    private void initData() {
        for (int i = 0; i < 200; i++) {
            GridItem item = new GridItem();
            item.setId(i+1);
            if(i % 2 == 0) {
                item.setUrl("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
            } else {
                item.setUrl("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
                //item.setUrl("http://img.d9soft.com/2015/0725/20150725114852556.gif");
            }
            mList.add(item);
        }
    }
}
