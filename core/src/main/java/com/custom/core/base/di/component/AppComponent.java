package com.custom.core.base.di.component;

import android.app.Application;

import com.custom.core.base.app.MyApplication;
import com.custom.core.base.di.module.AppModule;
import com.custom.core.base.di.scope.ApplicationScope;
import com.google.gson.Gson;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by: Ysw on 2020/3/31.
 */
@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MyApplication application);

    Application application();

    Gson gson();

    OkHttpClient okHttpClient();

}
