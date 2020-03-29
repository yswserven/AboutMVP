package com.custom.mvp.ui.presenter;

import android.util.Log;

import com.custom.core.base.mvp.BaseObserver;
import com.custom.core.base.mvp.BasePresenter;
import com.custom.mvp.ui.contract.MainContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    private final String TAG = this.getClass().getSimpleName();

    public MainPresenter(MainContract.Model model, MainContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        mRootView.showLoadingDialog();
        mModel.getHttpData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<String>(MainPresenter.this) {
                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: s = " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: e = " + e);
                    }
                });
    }
}
