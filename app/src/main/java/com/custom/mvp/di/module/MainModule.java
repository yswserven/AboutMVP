package com.custom.mvp.di.module;

import com.custom.mvp.ui.contract.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Ysw on 2020/3/31.
 */
@Module
public class MainModule {
    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.View provideView() {
        return view;
    }
}
