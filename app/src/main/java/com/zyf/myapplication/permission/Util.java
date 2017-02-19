package com.zyf.myapplication.permission;

import android.Manifest;

import java.util.List;

/**
 * Created by 11213 on 2017/1/5.
 */

public class Util {

    private void requestPermission(){
        BaseActivity.requestRunTimePermission(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                , new PermissionListener() {
                    @Override
                    public void onGranted() {

                    }

                    @Override
                    public void onGranted(List<String> grantedPermission) {

                    }

                    @Override
                    public void onDenied(List<String> deniedPermission) {

                    }
                });
    }
}
