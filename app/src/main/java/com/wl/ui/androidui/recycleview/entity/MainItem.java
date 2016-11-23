package com.wl.ui.androidui.recycleview.entity;

/**
 * recycle main page item.
 * Created by wangliang on 16-11-23.
 */

public class MainItem {
    private String content;
    private Class<?> clazz;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
