package com.custom.mvp.ui.presenter;

import android.util.Log;

import com.custom.core.base.mvp.BasePresenter;
import com.custom.mvp.ui.contract.MainContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {

    public MainPresenter(MainContract.Model model, MainContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        mRootView.showLoadingDialog();
        mModel.getHttpData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("Ysw", "onNext: s = " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Ysw", "onError: e = " + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
