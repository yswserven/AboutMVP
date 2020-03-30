package com.custom.core.net;

import com.custom.core.net.interceptor.ErrorHandlerInterceptor;
import com.custom.core.net.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by: Ysw on 2020/3/29.
 */
public final class RetrofitHelper {
    private static volatile RetrofitHelper singleton = null;
    private Retrofit retrofit;

    private RetrofitHelper() {
    }

    public static RetrofitHelper getInstance() {
        if (singleton == null) {
            synchronized (RetrofitHelper.class) {
                if (singleton == null) {
                    singleton = new RetrofitHelper();
                }
            }
        }
        return singleton;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            String baseUrl = Api.BASE_URL;
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getOkHttpClient())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .addInterceptor(new ErrorHandlerInterceptor())
                .cookieJar(new CookiesManager())
                .retryOnConnectionFailure(true)
                .build();
    }
}
