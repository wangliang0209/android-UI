package com.wl.ui.fresco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wl.ui.baselib.BaseActivity;

/**
 * Created by wangliang on 16-11-17.
 */

public class FrescoMainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fresco);

        initActionBarWithBack("Fresco Demo");

        findViewById(R.id.to_simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FrescoMainActivity.this, SimpleDraweeViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
