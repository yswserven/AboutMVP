package com.custom.core.net.interceptor;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import androidx.annotation.NonNull;

/**
 * Created by: Ysw on 2020/3/30.
 */
public class ErrorHandler extends Handler {
    private WeakReference<Context> mContext;

    ErrorHandler(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        int what = msg.what;
        Context context = this.mContext.get();
        if (context != null) {
            switch (what) {
                case 400:
                    Toast.makeText(context, "服务器400异常", Toast.LENGTH_SHORT).show();
                    break;
                case 503:
                    Toast.makeText(context, "服务器500异常", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
