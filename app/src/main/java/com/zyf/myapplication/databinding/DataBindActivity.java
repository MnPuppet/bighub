package com.zyf.myapplication.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zyf.myapplication.R;

/**
 * @author Kelvin
 * @time 2017/2/19 10:32
 * @des ${TODO}
 */

public class DataBindActivity extends AppCompatActivity {

    private ActivityDataBinding mDataBinding;
    private InfoBean mInfoBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_data);
        init();
        initListener();

    }

    private void init(){
        mInfoBean = new InfoBean("张三","李四");
        mDataBinding.setInfoBean(mInfoBean);
    }

    /**
     * 更改数据
     */
    public void initListener(){
       mDataBinding.chanage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mInfoBean.setFirstName("麻子");
               mInfoBean.setLastName("王五");
           }
       });
    }
}
