package com.custom.core.net;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;

public abstract class BaseReq {

    public RequestBody getRequestBody() {
        Gson gson = new Gson();
        String baseJson = gson.toJson(this);
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), baseJson);
    }

    public Map<String, String> getRequestMap() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        HashMap<String, String> params = new HashMap<>();
        params.put("data", json);
        return params;
    }
}
