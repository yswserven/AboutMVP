package com.custom.mvp.di.module;

import com.custom.mvp.ui.contract.MainContract;
import com.custom.mvp.ui.model.MainModel;
import com.custom.mvp.ui.presenter.MainPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by: Ysw on 2020/3/31.
 */
@Module
public class MainModule {
    private MainModel model;
    private MainContract.View view;

    @Inject
    public MainModule() {
    }

    @Provides
    MainPresenter provide() {
        return new MainPresenter(model, view);
    }

    public MainModule providerModule(MainModel model) {
        this.model = model;
        return this;
    }

    public MainModule providerView(MainContract.View view) {
        this.view = view;
        return this;
    }
}
