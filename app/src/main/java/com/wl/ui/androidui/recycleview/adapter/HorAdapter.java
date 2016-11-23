package com.wl.ui.androidui.recycleview.adapter;

import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.entity.ImageItem;

import java.util.List;

/**
 * Created by wangliang on 16-11-23.
 */

public class HorAdapter extends BaseQuickAdapter<ImageItem, BaseViewHolder> {

    public HorAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, ImageItem item) {
        SimpleDraweeView sdw = viewHolder.getView(R.id.image);
        sdw.setImageURI(Uri.parse(item.getUrl()));

        viewHolder.setText(R.id.text, String.valueOf(item.getId()));
    }

}
