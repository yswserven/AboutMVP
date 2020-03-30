package com.custom.core.net.interceptor;

import android.os.Message;

import com.custom.core.base.app.MyApplication;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by: Ysw on 2020/3/30.
 */
public class ErrorHandlerInterceptor implements Interceptor {
    private ErrorHandler handler = new ErrorHandler(MyApplication.getInstance());

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        int code = response.code();
        Message message = new Message();
        switch (code) {
            case 400:
                message.what = 400;
                handler.sendMessage(message);
                break;
            case 503:
                message.what = 500;
                handler.sendMessage(message);
                break;
        }
        return response;
    }
}
