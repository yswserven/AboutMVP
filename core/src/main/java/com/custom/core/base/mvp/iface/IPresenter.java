package com.custom.core.base.mvp.iface;

/**
 * Created by: Ysw on 2020/2/23.
 */
public interface IPresenter<T extends IView> {
    void onStart();

    void onDestroy();
}
