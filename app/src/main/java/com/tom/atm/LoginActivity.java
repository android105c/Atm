package com.tom.atm;

import android.content.SharedPreferences;
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
    private static final String PREF_USERID = "PREF_USERID";
    private static final String PREF_PASSWD = "PREF_PASSWD";

    @BindView(R.id.userid) EditText edUserid;
    @BindView(R.id.passwd) EditText edPasswd;
    @BindView(R.id.btnLogin) Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        SharedPreferences pref = getSharedPreferences("atm",MODE_PRIVATE);
        edUserid.setText(pref.getString(PREF_USERID, ""));
        edPasswd.setText(pref.getString(PREF_PASSWD, ""));
//        btnLogin.setText("LOGIN");
    }

    @OnClick(R.id.btnLogin) void login(){
        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();
        Log.d("onclick", userid);
        if (userid.equals("jack") && passwd.equals("1234")){
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString(PREF_USERID, userid)
                    .putString(PREF_PASSWD, passwd)
                    .commit();

            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            getIntent().putExtra("USERID",userid);
            getIntent().putExtra("PASSWD", passwd);
            setResult(RESULT_OK,getIntent());
            finish();
        }else{
            Toast.makeText(this, "登入錯誤", Toast.LENGTH_LONG).show();
        }
    }
}
