package com.wl.ui.androidui.recycleview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wl.ui.androidui.R;
import com.wl.ui.banner.Banner;

/**
 * Created by wangliang on 16-11-18.
 */

public class BannerWithFresco extends Banner {
    public BannerWithFresco(Context context) {
        this(context, null);
    }
    public BannerWithFresco(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerWithFresco(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected View generImageView() {
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setFadeDuration(500) // 设置出现的渐变时间
                .setPlaceholderImage(R.drawable.default_image) //设置默认图
                // 其他请参考文档 https://www.fresco-cn.org/docs/drawee-branches.html#Retry
                .build();
        simpleDraweeView.setHierarchy(hierarchy);
        return simpleDraweeView;
    }
}
