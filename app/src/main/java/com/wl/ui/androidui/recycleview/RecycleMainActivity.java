package com.wl.ui.androidui.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wl.ui.androidui.R;
import com.wl.ui.baselib.BaseActivity;

/**
 * Created by wangliang on 16-11-18.
 */

public class RecycleMainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_example);

        initActionBarWithBack("RecycleView Demo");

    }


}
