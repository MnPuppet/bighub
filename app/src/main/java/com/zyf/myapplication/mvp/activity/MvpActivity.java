package com.zyf.myapplication.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zyf.myapplication.R;
import com.zyf.myapplication.mvp.presenter.login.LoginPredenter;
import com.zyf.myapplication.mvp.view.login.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Kelvin
 * @time 2017/1/13 16:07
 * @des ${TODO}
 */

public class MvpActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.psw)
    EditText mPsw;
    @BindView(R.id.login)
    Button mLogin;

    private LoginPredenter mLoginPredenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        ButterKnife.bind(this);

        mLoginPredenter = new LoginPredenter(this);
    }

    @Override
    public String getUsername() {
        return mUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return mPsw.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login)
    void setLogin(){
        mLoginPredenter.login();
        mUsername.setText("");
        mPsw.setText("");
    }
}
