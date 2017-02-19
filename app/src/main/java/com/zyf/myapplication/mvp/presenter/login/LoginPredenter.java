package com.zyf.myapplication.mvp.presenter.login;

import com.zyf.myapplication.mvp.model.login.LoginModelImple;
import com.zyf.myapplication.mvp.model.login.LoginPort;
import com.zyf.myapplication.mvp.model.login.OnLoginListener;
import com.zyf.myapplication.mvp.view.login.LoginView;

/**
 * @author Kelvin
 * @time 2017/1/13 16:24
 * @des presenter：主导器  通过View和Modle的实现类来操作Modle和View
 * Activity可以把所有的逻辑都交给presenter处理
 */

public class LoginPredenter implements OnLoginListener {

    private LoginPort loginPort;//登录接口
    private LoginView loginView;//登录veiw

    //实例化登录接口和登录view
    public LoginPredenter(LoginView loginView){
        this.loginView = loginView;
        loginPort = new LoginModelImple();
    }

    /**
     * 将从view层中获取的用户名和密码传送给Model层
     * 然后让activity中的登录按钮调用此方法
     */
    public void login(){
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        loginPort.login(username,password,this);
    }

    @Override
    public void onUsernameError() {
        loginView.showToast("用户名或者密码错误");
    }

    @Override
    public void onPasswordError() {
        loginView.showToast("用户名或者密码错误");
    }

    @Override
    public void onSuccess() {
        loginView.showToast("登录成功！");
    }

    @Override
    public void onFailure() {
        loginView.showToast("异常错误！");
    }
}
