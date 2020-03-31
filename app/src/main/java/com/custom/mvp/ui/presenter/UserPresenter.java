package com.custom.mvp.ui.presenter;

import com.custom.core.base.mvp.BasePresenter;
import com.custom.core.unit.MyLog;
import com.custom.mvp.ui.contract.UserContract;

import javax.inject.Inject;

/**
 * Created by: Ysw on 2020/3/31.
 */
public class UserPresenter extends BasePresenter<UserContract.Model, UserContract.View> {
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View view) {
        super(model, view);
    }

    public void getUserInfo() {
        MyLog.d(TAG, "UserPresenter.getUserInfo：" + "没有出现空指针，正在请求数据");
    }
}
