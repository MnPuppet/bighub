package com.zyf.myapplication.permission;

import java.util.List;

/**
 * Created by 11213 on 2017/1/4.
 * 权限回调接口
 */

public interface PermissionListener {

    //授权成功
    void onGranted();

    //授权部分
    void onGranted(List<String> grantedPermission);

    //拒绝授权
    void onDenied(List<String> deniedPermission);
}
