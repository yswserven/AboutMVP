package com.custom.mvp.model;

import com.google.gson.Gson;

import okhttp3.RequestBody;

public abstract class BaseReq {

    public RequestBody getRequestBody() {
        Gson gson = new Gson();
        String baseJson = gson.toJson(this);
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), baseJson);
    }
}
