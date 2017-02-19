package com.zyf.myapplication.mvp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zyf.myapplication.R;
import com.zyf.myapplication.mvp.presenter.network.NetPresenter;
import com.zyf.myapplication.mvp.view.network.NetView;

/**
 * @author Kelvin
 * @time 2017/1/16 15:43
 * @des 实现View层的接口和创建presenter的对象
 */

public class NetActivity extends AppCompatActivity implements NetView{

    private NetPresenter mNetPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        mNetPresenter = new NetPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNetPresenter.didFinishLoading(this);
    }

    @Override
    public void showProcessBar() {
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setCanceledOnTouchOutside(true);
            mProgressDialog.setMessage("更新数据中，请稍后。。。。。");

        }

        mProgressDialog.show();
    }

    @Override
    public void hideProcessBar() {
        mProgressDialog.hide();
    }

    @Override
    public void showNetError() {
        Toast. makeText(this, "暂无网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startNextActivity() {
        Toast. makeText(this, "跳到下个activity", Toast.LENGTH_SHORT).show();
    }
}
