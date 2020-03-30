package com.custom.core.base.mvp;

import com.custom.core.base.mvp.iface.IModel;
import com.custom.core.base.mvp.iface.IPresenter;
import com.custom.core.base.mvp.iface.IView;

import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by: Ysw on 2020/3/29.
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {
    protected M mModel;
    protected V mRootView;
    private ConcurrentHashMap<V, CompositeDisposable> mCompositeDisposableMap = new ConcurrentHashMap<>();


    public BasePresenter(M mModel, V mRootView) {
        this.mModel = mModel;
        this.mRootView = mRootView;
        onStart();
    }

    public BasePresenter(V rootView) {
        this.mRootView = rootView;
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void addDisposable(Disposable subscription) {
        if (mRootView != null) {
            CompositeDisposable compositeDisposable = mCompositeDisposableMap.get(mRootView);
            if (compositeDisposable == null || compositeDisposable.isDisposed()) {
                compositeDisposable = new CompositeDisposable();
                mCompositeDisposableMap.put(mRootView,compositeDisposable);
            }
            compositeDisposable.add(subscription);
        }
    }

    public  <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

    @Override
    public void onDestroy() {
        unDisposable();
        if (mModel != null)
            mModel.onDestroy();
        this.mModel = null;
        this.mRootView = null;

    }

    @Override
    public void unDisposable() {
        if (mRootView != null) {
            CompositeDisposable compositeDisposable = mCompositeDisposableMap.get(mRootView);
            if (compositeDisposable != null) {
                compositeDisposable.dispose();
            }
        }
    }
}
