package com.wl.ui.androidui.recycleview.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.ui.androidui.R;
import com.wl.ui.androidui.recycleview.entity.MultipleItem;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    public MultipleItemQuickAdapter(Context context, List data) {
        super(data);
        mContext = context;
        addItemType(MultipleItem.TEXT, R.layout.item_text_view);
        addItemType(MultipleItem.IMG, R.layout.item_image_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv, item.getContent());
                break;
            case MultipleItem.IMG:
                // set img data
                ImageView iv = helper.getView(R.id.iv);
                Glide.with(mContext)
                        .load(item.getContent())
                        .placeholder(com.wl.ui.glide.R.drawable.default_image)
                        .fitCenter()
                        .crossFade(3000) //淡入淡出
                        .dontAnimate()
                        .into(iv);

                break;
        }
    }

}
