package com.wl.ui.glide;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wl.ui.baselib.BaseActivity;

/**
 * Created by wangliang on 16-11-24.
 */

public class GlideMainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_glide);

        initActionBarWithBack("Glide Demo");

        ImageView iv1 = (ImageView) findViewById(R.id.image_view_1);
        ImageView iv2 = (ImageView) findViewById(R.id.image_view_2);
        ImageView iv3 = (ImageView) findViewById(R.id.image_view_3);
        ImageView iv4 = (ImageView) findViewById(R.id.image_view_4);

        Glide.with(this)
                .load("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg")
                .placeholder(R.drawable.default_image)
                .fitCenter()
                .crossFade(3000) //淡入淡出
                .into(iv1);


    }
}
