package com.custom.mvp.di.component;

import com.custom.mvp.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by: Ysw on 2020/2/23.
 */

@Singleton
@Component
public interface UserComponent {
    void inject(MainActivity activity);
}
