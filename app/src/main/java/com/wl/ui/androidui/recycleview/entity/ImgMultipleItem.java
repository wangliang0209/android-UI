package com.wl.ui.androidui.recycleview.entity;

/**
 * Created by wangliang on 16-11-24.
 */

public class ImgMultipleItem extends MultipleItem {

    public ImgMultipleItem(String content) {
        //暂时content为图片url 想拓展可以将其定义为json
        super(MultipleItem.IMG, content);
    }
}
