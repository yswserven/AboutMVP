package com.custom.mvp.ui.model;

import com.custom.core.base.mvp.BaseModel;
import com.custom.core.net.Api;
import com.custom.core.net.CommonApi;
import com.custom.core.net.RetrofitHelper;
import com.custom.mvp.ui.contract.UserContract;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by: Ysw on 2020/3/31.
 */
public class UserModel extends BaseModel implements UserContract.Model {
    @Inject
    public UserModel() {
    }

    @Override
    public Observable<String> getUserInfo() {
        return RetrofitHelper.getInstance()
                .getRetrofit()
                .create(CommonApi.class)
                .get(Api.Method.GET, null);
    }
}
