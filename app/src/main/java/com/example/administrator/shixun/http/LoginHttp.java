package com.example.administrator.shixun.http;

import com.example.administrator.shixun.config.Link;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
  shixun
 登陆页Http请求
 **/
public class LoginHttp {
    OkHttpClient client=null;
    /**
     * POST请求
    */
    public String post(String username,String password) throws IOException {
        client = new OkHttpClient();
        FormBody formBody=new FormBody.Builder()
                .add("user",username)
                .add("password",password)
                .build();
        final Request request = new Request.Builder().post(formBody).url(Link.login).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }
}
