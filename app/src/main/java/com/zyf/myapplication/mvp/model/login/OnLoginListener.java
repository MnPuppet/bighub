package com.zyf.myapplication.mvp.model.login;

/**
 * @author Kelvin
 * @time 2017/1/13 16:21
 * @des ${TODO}
 */

public interface OnLoginListener {

    //用户名错误
    void onUsernameError();
    //密码错误
    void onPasswordError();
    //登陆成功
    void onSuccess();
    //请求失败
    void onFailure();
}
