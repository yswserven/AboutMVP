package com.custom.core.net.interceptor;

import com.custom.core.unit.MyLog;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by: Ysw on 2020/3/30.
 */
public class LogInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        MyLog.d("Ysw", "intercept: requestInfo :" + request.toString());
        Response response = chain.proceed(request);
        MyLog.d("Ysw", "intercept: responseInfo :" + Objects.requireNonNull(response.body()).toString());
        return response;
    }
}
