package com.wl.ui.androidui.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wl.ui.androidui.R;

/**
 * Created by wangliang on 16-11-21.
 */

public class ExampleFragment extends Fragment {
    private View mRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_example, null);

        //TODO

        return mRootView;
    }
}
