package com.wl.ui.androidui;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by wangliang on 16-11-17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化fresco
        Fresco.initialize(this);
    }
}
