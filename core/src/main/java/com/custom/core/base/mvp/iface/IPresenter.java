package com.custom.core.base.mvp.iface;

import io.reactivex.disposables.Disposable;

/**
 * Created by: Ysw on 2020/2/23.
 */
public interface IPresenter<T extends IView> {
    void onStart();

    void addDisposable(Disposable subscription);

    void onDestroy();

    void unDisposable();
}
