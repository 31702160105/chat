package com.example.administrator.shixun.business;

import com.example.administrator.shixun.http.RegisterHttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
注册页面业务
 **/
public class RegisterBes {
    /**
     注册用户
     name//用户名
     username//账号
     password//密码
    */
    public boolean doRegister(String name,String username,String password){
        try {
            RegisterHttp registerBes=new RegisterHttp();
            String res=registerBes.post(name,username,password);
            JSONObject jsonObject=new JSONObject(res);
            String islog=jsonObject.getString("status");
            if ("注册成功".equals(islog)){
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
