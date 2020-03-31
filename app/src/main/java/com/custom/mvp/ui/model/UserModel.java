package com.custom.mvp.ui.model;

import com.custom.core.base.mvp.BaseModel;
import com.custom.mvp.ui.contract.UserContract;

import io.reactivex.Observable;

/**
 * Created by: Ysw on 2020/3/31.
 */
public class UserModel extends BaseModel implements UserContract.Model {
    @Override
    public Observable<String> getUserInfo() {
        return null;
    }
}
