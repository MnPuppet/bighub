package com.zyf.myapplication.mvp.view.network;

/**
 * @author Kelvin
 * @time 2017/1/16 15:21
 * @des View主要是操作UI界面，更新UI界面，是一个接口，需要Activity来实现
 */

public interface NetView {

    void showProcessBar();
    void hideProcessBar();
    void showNetError();
    void startNextActivity();
}
