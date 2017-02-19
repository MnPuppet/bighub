package com.zyf.myapplication.permission;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.zyf.myapplication.R;

import java.util.List;

/**
 * Created by 11213 on 2017/1/5.
 */

public class ThreeActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                requestPermission();
                break;
            default:
                break;
        }
    }

    private void requestPermission(){
        requestRunTimePermission(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                , new PermissionListener() {
                    @Override
                    public void onGranted() {  //所有权限授权成功

                    }

                    @Override
                    public void onGranted(List<String> grantedPermission) { //授权失败权限集合

                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) { //授权成功权限集合

                    }
                });
    }
}
