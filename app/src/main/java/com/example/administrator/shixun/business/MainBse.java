package com.example.administrator.shixun.business;

import com.example.administrator.shixun.bean.MainBean;
import com.example.administrator.shixun.http.MainHttp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 聊天页面
 **/
public class MainBse {
    private List<MainBean> list=null;
    /**
    发送信息并返回聊天记录
    key//密匙
    chat//要发送的聊天信息
    */
    public List<MainBean> send(String key,String chat){
        try {
            MainHttp mainHttp=new MainHttp();
            String res=mainHttp.post(key,chat);
            list=new ArrayList<MainBean>();
            JSONArray jsonArray=new JSONArray(res);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                MainBean mainBean=new MainBean();
                mainBean.setChat(jsonObject.getString("chat"));
                mainBean.setTime(jsonObject.getString("time"));
                mainBean.setName(jsonObject.getString("name"));
                list.add(mainBean);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
