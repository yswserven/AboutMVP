package com.custom.mvp.di.module;

import com.custom.mvp.ui.contract.UserContract;
import com.custom.mvp.ui.model.UserModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Ysw on 2020/3/31.
 */
@Module
public class UserModule {
    private UserContract.View view;

    public UserModule(UserContract.View view) {
        this.view = view;
    }

    @Provides
    UserContract.View provideView() {
        return view;
    }

    @Provides
    UserContract.Model providerModel() {
        return new UserModel();
    }
}
