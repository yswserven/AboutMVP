package com.custom.core.base.mvp.iface;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Created by: Ysw on 2020/3/29.
 */
public interface IActivity {

    int initLayout(@Nullable Bundle savedInstanceState);

    void initData(@Nullable Bundle savedInstanceState);

}
