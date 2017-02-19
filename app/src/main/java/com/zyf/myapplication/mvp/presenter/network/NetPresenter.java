package com.zyf.myapplication.mvp.presenter.network;

import android.content.Context;

import com.zyf.myapplication.mvp.model.network.INetConnet;
import com.zyf.myapplication.mvp.model.network.NetConnet;
import com.zyf.myapplication.mvp.view.network.NetView;

/**
 * @author Kelvin
 * @time 2017/1/16 15:23
 * @des 主导器
 */

public class NetPresenter {
    //Modle
    private INetConnet mINetConnet;
    //View
    private NetView mNetView;

    //构造器
    public  NetPresenter(NetView mNetView){
        this.mNetView = mNetView;
        mINetConnet = new NetConnet();
    }

    //逻辑处理
    public void didFinishLoading(Context context){
        mNetView.showProcessBar();

        if (mINetConnet.isNetConnet(context)) {
            mNetView.startNextActivity();
        }else{
            mNetView.showNetError();
        }

        mNetView.hideProcessBar();
    }
}
