package com.example.administrator.shixun.config;

/**

  API链接库

 **/
public class Link {
    /** 
     登陆接口
     user//用户名
     password//用户名
     JSON

    */ 
    public static final String login="http://123.207.85.214/chat/login.php";
    /** 
     注册接口
     name//用户名
     user//账号
     password//密码
     JSON

    */ 
    public static final String register="http://123.207.85.214/chat/register.php";
    /** 
     聊天接口
     user//密匙
     chat//聊天信息
     JSON

    */ 
    public static final String chat="http://123.207.85.214/chat/chat1.php";
    /** 
     用户列表接口
     JSON
    */ 
    public static final String member="http://123.207.85.214/chat/member.php";
}
