package com.tom.atm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.userid) EditText edUserid;
    @BindView(R.id.passwd) EditText edPasswd;
    @BindView(R.id.btnLogin) Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
//        btnLogin.setText("LOGIN");
    }

    @OnClick(R.id.btnLogin) void login(){
        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();
        Log.d("onclick", userid);
        if (userid.equals("jack") && passwd.equals("1234")){
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            setResult(RESULT_OK);
            finish();
        }else{
            Toast.makeText(this, "登入錯誤", Toast.LENGTH_LONG).show();
        }
    }
}
