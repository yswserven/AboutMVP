package com.custom.core.base.app;

import android.app.Application;
import android.content.Context;

import com.custom.core.unit.MyLog;

/**
 * Created by: Ysw on 2020/2/23.
 */
public class MyApplication extends Application {
    public static Application mInstance = new MyApplication();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyLog.init();
    }

    public static Application getInstance(){
        return mInstance;
    }
}
