package com.zyf.myapplication.mvp.model.login;

/**
 * @author Kelvin
 * @time 2017/1/16 14:21
 * @des modle层主要是用来处理业务逻辑的，一般分为两部分：nodle中的接口和实现类
 */

public class LoginModelImple implements LoginPort {

    @Override
    public void login(String username, String psw, OnLoginListener onLoginListener) {
        if(username.equals("admin") && psw.equals("123456")){
            onLoginListener.onSuccess();//登录成功
        }else if(!username.equals("admian") || !psw.equals("123456")){
            onLoginListener.onUsernameError();//用户名或者密码错误
        }else {
            onLoginListener.onFailure();//登录失败
        }
    }
}
