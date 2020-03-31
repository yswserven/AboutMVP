package com.custom.mvp.di.module;

import com.custom.mvp.ui.contract.UserContract;
import com.custom.mvp.ui.model.UserModel;
import com.custom.mvp.ui.presenter.UserPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Ysw on 2020/3/31.
 */
@Module
public class UserModule {
    private UserModel model;
    private UserContract.View view;

    @Inject
    public UserModule() {
    }

    @Provides
    UserPresenter provide() {
        return new UserPresenter(model, view);
    }

    public UserModule providerModule(UserModel model) {
        this.model = model;
        return this;
    }

    public UserModule providerView(UserContract.View view) {
        this.view = view;
        return this;
    }
}
