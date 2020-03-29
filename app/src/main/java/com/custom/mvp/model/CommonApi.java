package com.custom.mvp.model;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.HTTP;

public interface CommonApi {

    /**
     * 系统初始化接口
     */
    @HTTP(method = Api.REQUEST_METHOD, path = Api.APP_DOMAIN, hasBody = true)
    Observable<HttpResult<SystemInitEntity>> systemInit(@Body RequestBody body);
}
