package com.example.administrator.shixun.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.shixun.R;
import com.example.administrator.shixun.business.LoginBse;

import java.util.Map;

public class Login extends AppCompatActivity {
    private Button btn_login;
    private EditText username;
    private EditText password;
    private Button zhuce;
    /**
     * 提示
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    Toast.makeText(getApplicationContext(), msg.obj.toString().trim(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passlogin();

            }
        });
        findViewById(R.id.zhuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passzhuce();
            }
        });
    }

    /**
      初始化控件

     */
    void init() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    /**
     登陆

     */
    public void passlogin() {
        new Thread() {
            @Override
            public void run() {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                LoginBse loginBse = new LoginBse();
                Map<String,String> map=loginBse.doLogin(user, pass);

                if (!username.getText().toString().equals("")&&!password.getText().toString().equals("")){
                    if ("登陆成功".equals(map.get("status"))) {
                        Message msg=new Message();
                        msg.what=100;
                        msg.obj="登陆成功";

                        handler.sendMessage(msg);
                        Intent intent = new Intent(getApplicationContext(), Main.class);
                        intent.putExtra("key",map.get("key"));
                        intent.putExtra("name",map.get("name"));
                        startActivity(intent);
                        finish();
                    } else {
                        Message msg=new Message();
                        msg.what=100;
                        msg.obj="登陆失败";
                        handler.sendMessage(msg);
                    }
                }else {
                    Log.e("123", "run: "+"登录失败" );
                }

            }
        }.start();
    }

    /**
    注册

     */
    public void passzhuce() {
        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);
    }
}
