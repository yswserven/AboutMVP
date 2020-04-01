package com.custom.mvp.ui.presenter;

import com.custom.core.base.mvp.BaseObserver;
import com.custom.core.base.mvp.BasePresenter;
import com.custom.core.unit.MyLog;
import com.custom.mvp.ui.contract.UserContract;
import com.custom.mvp.ui.model.UserModel;

import javax.inject.Inject;

/**
 * Created by: Ysw on 2020/3/31.
 */
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    public UserPresenter(UserModel model, UserContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        subscribe(mModel.getUserInfo(), new BaseObserver<String>(this) {
            @Override
            public void onNext(String s) {
                mRootView.successUserInfo(s);
                MyLog.d(TAG, "UserPresenter.onNext：" + s);
            }
        });
    }
}
