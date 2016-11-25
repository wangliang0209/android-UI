package com.wl.ui.androidui.refresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.adapter.VerticalAdapter;
import com.wl.ui.androidui.recycleview.entity.VerticalItem;
import com.wl.ui.baselib.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * 下拉刷新及加载更多
 * Created by wangliang on 16-11-25.
 */

public class RefreshMainActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener {
    private static final int STYPE_NORMAL = 0; //普通
    private static final int STYPE_STORE = 1; //字符飞出 类似例子效果


    private RecyclerView mRecyclerView;
    private View notDataView;
    private BaseQuickAdapter mAdapter;
    private List<VerticalItem> mList = new ArrayList<>();

    private boolean mIsDisplayEmpty; //是否展现空view

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_main);

        initActionBarWithBack("下拉刷新 Demo");

        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) findViewById(R.id.fragment_ptr_home_ptr_frame);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);

        initPtrFrameLayout(ptrFrameLayout, STYPE_NORMAL);

        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //TODO 刷新数据
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsDisplayEmpty = !mIsDisplayEmpty;
                        if(mIsDisplayEmpty) {
                            mList.clear();
                            mAdapter.notifyDataSetChanged();
                        } else {
                            refreshData();
                            mAdapter.setNewData(mList); //必须用这个方法，否则加载更多没法设置
                        }
                        ptrFrameLayout.refreshComplete();
                    }
                }, 1500);
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshData();
        mAdapter = new VerticalAdapter(R.layout.recycle_vertical_item_view, mList);
        mAdapter.openLoadAnimation();
        mAdapter.setOnLoadMoreListener(this);

        //设置空view
        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRecyclerView.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrameLayout.autoRefresh(true);
                    }
                }, 150);
            }
        });
        mAdapter.setEmptyView(notDataView);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
                Log.d("WLTest", String.valueOf(position + 1));
                Toast.makeText(RefreshMainActivity.this, Integer.toString(position + 1), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }

    private void refreshData() {
        mList.clear();
        for (int i = 0; i < 20; i++) {
            VerticalItem item = new VerticalItem();
            item.setText("item:" + (i + 1));
            item.setUrl("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
            mList.add(item);
        }
    }


    private void addMoreData() {
        Log.d("WLTest", "addMoreData");
        int start = mList.size();
        for (int i = 0; i < 10; i++) {
            VerticalItem item = new VerticalItem();
            item.setText("item:more" + (start +i + 1));
            item.setUrl("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");
            mList.add(item);
        }
    }

    @Override
    public void onLoadMoreRequested() {
        //　TODO 异步加载更多数据
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO 数据加载后刷新UI
                mAdapter.loadMoreComplete();// 完成一次加载必须增加该句，否则不会再执行
                addMoreData();
                mAdapter.notifyDataSetChanged();
                if(mList.size() >= 50) {
                    mAdapter.loadMoreEnd();
                }

            }
        }, 2000);
    }


    private void initPtrFrameLayout(PtrFrameLayout ptrFrame, int flag) {
        if(flag == 1) {
            StoreHouseHeader header = new StoreHouseHeader(this);
//        header.setPadding(0, 0, 0, 0);
            header.initWithString("LOADING DATA");
            header.setTextColor(getResources().getColor(R.color.color_333333));
            ptrFrame.setDurationToCloseHeader(1500);
            ptrFrame.setHeaderView(header);
            ptrFrame.addPtrUIHandler(header);
        } else {
            ptrFrame.setResistance(1.7f);
            ptrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
            ptrFrame.setDurationToClose(200);
            ptrFrame.setDurationToCloseHeader(1000);
            ptrFrame.setPullToRefresh(true);
            PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(this);
            ptrFrame.setHeaderView(header);
            ptrFrame.addPtrUIHandler(header);
        }
    }

}
