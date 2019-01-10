package com.example.administrator.shixun.http;

import com.example.administrator.shixun.config.Link;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 shixun
聊天页Http请求

 **/
public class MainHttp {
    OkHttpClient client=null;
    /**
      POST请求
     */
    public String post(String user,String chat) throws IOException {
        client = new OkHttpClient();
        FormBody formBody=new FormBody.Builder()
                .add("user",user)
                .add("chat",chat)
                .build();
        final Request request = new Request.Builder().post(formBody).url(Link.chat).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return null;
        }
    }
}
