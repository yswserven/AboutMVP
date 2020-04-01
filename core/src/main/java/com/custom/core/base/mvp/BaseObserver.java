package com.custom.core.base.mvp;

import com.custom.core.unit.MyLog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by: Ysw on 2020/3/30.
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private final String TAG = this.getClass().getSimpleName();
    private BasePresenter basePresenter;

    public BaseObserver(BasePresenter basePresenter) {
        this.basePresenter = basePresenter;
    }

    @Override
    public void onSubscribe(Disposable d) {
        basePresenter.addDisposable(d);
    }

    @Override
    public void onComplete() {
        basePresenter.unDisposable();
    }

    @Override
    public void onError(Throwable e) {
        basePresenter.unDisposable();
        MyLog.d(TAG, "MainPresenter.onError：e = " + e);
    }
}
