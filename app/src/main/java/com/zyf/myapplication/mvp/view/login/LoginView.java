package com.zyf.myapplication.mvp.view.login;

/**
 * @author Kelvin
 * @time 2017/1/13 16:12
 * @des view层，主要是用来维护视图层，更新视图层状态
 */

public interface LoginView {
    //获取activity中的用户名密码
    String getUsername();
    String getPassword();

    //显示信息
    void showToast(String msg);
}
