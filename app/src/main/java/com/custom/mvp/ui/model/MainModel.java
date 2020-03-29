package com.custom.mvp.ui.model;

import com.custom.core.base.mvp.BaseModel;
import com.custom.mvp.model.Api;
import com.custom.mvp.model.CommonApi;
import com.custom.mvp.ui.contract.MainContract;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainModel extends BaseModel implements MainContract.Model {
    @Override
    public Observable<String> getHttpData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.APP_DOMAIN)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        CommonApi commonApi = retrofit.create(CommonApi.class);
        return commonApi.get(Api.Method.GET,null);
    }


}
