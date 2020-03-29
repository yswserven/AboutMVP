package com.custom.core.base.app;

import android.app.Application;

import com.custom.core.unit.MyLog;

/**
 * Created by: Ysw on 2020/2/23.
 */
public class MyApplication extends Application {
    public static Application mInstance = new MyApplication();
    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.init();
    }

    public static Application getInstance(){
        return mInstance;
    }
}
