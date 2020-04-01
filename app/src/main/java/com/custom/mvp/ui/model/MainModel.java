package com.custom.mvp.ui.model;

import com.custom.core.base.mvp.BaseModel;
import com.custom.core.net.Api;
import com.custom.core.net.CommonApi;
import com.custom.core.net.RetrofitHelper;
import com.custom.mvp.ui.contract.MainContract;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainModel extends BaseModel implements MainContract.Model {

    @Inject
    public MainModel() {
    }

    @Override
    public Observable<String> getHttpData() {
        return RetrofitHelper.getInstance()
                .getRetrofit()
                .create(CommonApi.class)
                .get(Api.Method.GET, null);
    }
}
