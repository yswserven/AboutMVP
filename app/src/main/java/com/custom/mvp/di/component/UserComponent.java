package com.custom.mvp.di.component;

import com.custom.mvp.di.module.UserModule;
import com.custom.mvp.ui.activity.UserActivity;

import dagger.Component;

/**
 * Created by: Ysw on 2020/3/31.
 */

@Component(modules = {UserModule.class})
public interface UserComponent {
    void inject(UserActivity userActivity);
}
