package com.example.administrator.shixun.http;

import com.example.administrator.shixun.config.Link;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**

 用户列表网络请求

 **/
public class UserHttp {
    OkHttpClient client=null;
    public String post() throws IOException {
        client = new OkHttpClient();
        FormBody formBody=new FormBody.Builder()
                .build();
        final Request request = new Request.Builder().post(formBody).url(Link.member).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }
}
