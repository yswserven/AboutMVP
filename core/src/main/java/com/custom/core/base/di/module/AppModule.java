package com.custom.core.base.di.module;

import android.app.Application;

import com.custom.core.base.app.MyApplication;
import com.custom.core.base.di.scope.ApplicationScope;
import com.custom.core.net.interceptor.ErrorHandlerInterceptor;
import com.custom.core.net.interceptor.LogInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by: Ysw on 2020/3/31.
 */

@Module
public class AppModule {

    @ApplicationScope
    @Provides
    Application provideApplication() {
        return new MyApplication();
    }

    @ApplicationScope
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @ApplicationScope
    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .addInterceptor(new ErrorHandlerInterceptor())
                .retryOnConnectionFailure(true)
                .build();
    }


}
