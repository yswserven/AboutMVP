package com.custom.mvp.ui.presenter;

import com.custom.core.base.mvp.BaseObserver;
import com.custom.core.base.mvp.BasePresenter;
import com.custom.core.unit.MyLog;
import com.custom.mvp.ui.contract.MainContract;
import com.custom.mvp.ui.model.MainModel;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    public MainPresenter(MainModel model, MainContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        subscribe(mModel.getHttpData(), new BaseObserver<String>(this) {
            @Override
            public void onNext(String s) {
                mRootView.successHttpData(s);
                MyLog.d(TAG, "MainPresenter.onNext：s = " + s);
            }
        });
    }
}
