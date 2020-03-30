package com.custom.mvp.ui.presenter;

import com.custom.core.base.mvp.BaseObserver;
import com.custom.core.base.mvp.BasePresenter;
import com.custom.core.unit.MyLog;
import com.custom.mvp.ui.contract.MainContract;

public class MainPresenter extends BasePresenter<MainContract.Model, MainContract.View> {
    private final String TAG = this.getClass().getSimpleName();

    public MainPresenter(MainContract.Model model, MainContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        mRootView.showLoadingDialog();
        subscribe(mModel.getHttpData(), new BaseObserver<String>(this) {
            @Override
            public void onNext(String s) {
                MyLog.d(TAG, "MainPresenter.onNext：s = " + s);
            }

            @Override
            public void onError(Throwable e) {
                MyLog.d(TAG, "MainPresenter.onError：e = " + e);
            }
        });
    }
}
