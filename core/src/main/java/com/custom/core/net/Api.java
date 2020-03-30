package com.custom.core.net;

/**
 * 接口常量类
 *
 * @author hulin
 */
public interface Api {
    String BASE_URL = "https://www.wanandroid.com";

    String REQUEST_SUCCESS = "200";

    String REQUEST_METHOD = "POST";

    interface Method {
        String REGISTER = "/user/register";

        String GET = "https://www.wanandroid.com/navi/json";

    }

}
