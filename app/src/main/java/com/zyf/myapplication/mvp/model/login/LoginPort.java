package com.zyf.myapplication.mvp.model.login;

/**
 * @author Kelvin
 * @time 2017/1/13 16:25
 * @des 登陆接口
 */

public interface LoginPort {

    void login(String username,String psw,OnLoginListener onLoginListener);
}
