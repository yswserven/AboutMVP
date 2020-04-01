package com.custom.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.custom.core.base.mvp.BaseActivity;
import com.custom.mvp.R;
import com.custom.mvp.di.component.DaggerUserComponent;
import com.custom.mvp.di.module.UserModule;
import com.custom.mvp.ui.contract.UserContract;
import com.custom.mvp.ui.presenter.UserPresenter;

import androidx.annotation.Nullable;

/**
 * Created by: Ysw on 2020/3/31.
 */
public class UserActivity extends BaseActivity<UserPresenter> implements UserContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerUserComponent.builder()
                .userModule(new UserModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initLayout(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_user;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void successUserInfo(String data) {

    }

    public void getUserInfo(View view) {
        mPresenter.getUserInfo();
    }
}
