package com.wl.ui.androidui.recycleview.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.entity.MainItem;

import java.util.List;

/**
 * Created by wangliang on 16-11-23.
 */

public class MainAdapter extends BaseQuickAdapter<MainItem, BaseViewHolder> {

    public MainAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, MainItem item) {
        viewHolder.setText(R.id.info_text, item.getContent());
    }

}
