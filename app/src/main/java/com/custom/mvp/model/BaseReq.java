package com.custom.mvp.model;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import okhttp3.RequestBody;

public abstract class BaseReq {

    private String v = Api.Config.APIVERSION;
    private String appid = Api.Config.APPID;
    private long timestamp = System.currentTimeMillis();
    private String unique_id = "000000000000000";
    private String app_v = "1.2.1";
    private String platform = Api.Config.PLATFORM;
    private String channel = "360";
    private String version = CommonUtil.getSystemVersion();
    private String model = CommonUtil.getSystemModel();
    private String token = "";

    /**
     * add hulin.dev 20180207
     *
     * @return RequestBody
     */
    public RequestBody getRequestBody() {
        Gson gson = new Gson();
        String baseJson = gson.toJson(this);
        String jsonStr = baseJson + Api.Config.SIGN_KEY;
        String md5Str = "";
        JSONObject jsonObject = new JSONObject();
        try {
            md5Str = Objects.requireNonNull(MD5.getMD5(jsonStr)).toUpperCase();
            jsonObject.put("sign", md5Str);
            jsonObject.put("data", baseJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
    }

    /**
     * 返回一个Map
     *
     * @author hulin.dev
     * @date 2018/5/23
     */
    public Map<String, String> getRequestMap() {
        Gson gson = new Gson();
        String baseJson = gson.toJson(this);
        String jsonStr = baseJson + Api.Config.SIGN_KEY;
        String md5Str = "";
        HashMap<String, String> params = new HashMap<>();
        try {
            md5Str = MD5.getMD5(jsonStr).toUpperCase();
            params.put("sign", md5Str);
            params.put("data", baseJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }
}
