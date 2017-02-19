package com.zyf.myapplication.mvp.model.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Kelvin
 * @time 2017/1/16 15:17
 * @des Modle实现类
 */

public class NetConnet implements INetConnet {
    @Override
    public boolean isNetConnet(Context context) {
        if (context != null) {
            //判断是否有网络
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }
}
