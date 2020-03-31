package com.custom.mvp.di.component;

import com.custom.mvp.di.module.MainModule;
import com.custom.mvp.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by: Ysw on 2020/3/31.
 */

@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
