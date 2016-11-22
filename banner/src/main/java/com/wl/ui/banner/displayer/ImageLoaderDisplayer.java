package com.wl.ui.banner.displayer;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/**
 * Created by wangliang on 16-11-18.
 */

public class ImageLoaderDisplayer {
    private DisplayImageOptions defaultImageOptions = new DisplayImageOptions.Builder()
            .cacheInMemory(true)//设置下载的图片是否缓存在内存中
            .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
            .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
            .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
            .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
            .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
            .build();//构建完成;

    private int resId;

    public ImageLoaderDisplayer(int resId) {
        this.resId = resId;
        setDefaultRid(resId);
    }

    public void setDefaultRid(int resId) {
        defaultImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)//设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位
                .showImageOnLoading(resId)
                .showImageOnFail(resId)
                .showImageForEmptyUri(resId)
                .build();//构建完成;
    }

    public void displayImage(String url, ImageView iv) {
        ImageLoader.getInstance().displayImage(url, iv, defaultImageOptions);
    }
}
