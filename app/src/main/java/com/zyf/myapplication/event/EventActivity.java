package com.zyf.myapplication.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zyf.myapplication.R;

/**
 * Created by 11213 on 2017/1/10.
 */

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Log.e("main","点击了按钮一");
                break;
            case R.id.button2:
                Log.e("main","点击了按钮二");
                break;

            default:
                break;
            }
    }
}
