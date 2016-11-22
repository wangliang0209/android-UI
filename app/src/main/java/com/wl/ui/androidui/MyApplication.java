package com.wl.ui.androidui;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by wangliang on 16-11-17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化fresco
        Fresco.initialize(this);


        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this)
                ;

        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
    }
}
