package com.custom.core.base.mvp;

import com.custom.core.base.mvp.iface.IModel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by: Ysw on 2020/3/29.
 */
public class BaseModel implements IModel, LifecycleObserver {
    @Override
    public void onDestroy() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }
}
