package com.custom.mvp.ui.contract;

import com.custom.core.base.mvp.iface.IModel;
import com.custom.core.base.mvp.iface.IView;

import io.reactivex.Observable;

/**
 * Created by: Ysw on 2020/3/31.
 */
public interface UserContract {
    interface View extends IView {
        void successUserInfo(String data);
    }

    interface Model extends IModel {

        Observable<String> getUserInfo();
    }
}
