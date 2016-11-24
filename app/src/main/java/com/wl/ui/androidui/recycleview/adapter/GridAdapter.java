package com.wl.ui.androidui.recycleview.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.entity.GridItem;

import java.util.List;

/**
 * Created by wangliang on 16-11-23.
 */

public class GridAdapter extends BaseQuickAdapter<GridItem, BaseViewHolder> {
    private Context mContext;
    public GridAdapter(Context context, int layoutResId, List data) {
        super(layoutResId, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, GridItem item) {
        final ImageView iv = viewHolder.getView(R.id.image);
        Glide.with(mContext)
                .load(item.getUrl())
                .placeholder(com.wl.ui.glide.R.drawable.default_image)
                .fitCenter()
                .crossFade(3000) //淡入淡出
                .dontAnimate()
                .into(iv);
    }

}
