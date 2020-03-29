package com.custom.mvp.model;


public class HttpResult<T> {

    private String code;
    private String msg;
    private T data;


    public T getData() {
        return data;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


    public boolean isSuccess() {
        return Api.REQUEST_SUCCESS.equals(code);
    }

    public boolean hasData() {
        return Api.REQUEST_SUCCESS.equals(code) && data != null;
    }

}
