package com.custom.core.base.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Created by: Ysw on 2020/2/23.
 */
public interface IActivity {
    int initView(@Nullable Bundle savedInstanceState);

    void initData(@Nullable Bundle savedInstanceState);
}
