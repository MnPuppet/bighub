package com.zyf.myapplication.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.zyf.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by 11213 on 2017/1/6.
 * Butterknife界面
 */

public class ButterKnifeActivity extends AppCompatActivity {

    @BindView(R.id.tv_butterknife)
    TextView tvButterknife;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        //Activity中使用ButterKnife需要写上这句话
        ButterKnife.bind(this);

        initData();

    }

    private void initData(){
        tvButterknife.setText("Butterknife是一个好东西");

        tvButterknife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * 这个是CheckBook的选中改变监听事件
     * @param b 这个代表的是是否选中
     */
    @OnCheckedChanged(R.id.checkbox)
    void setCheckbox(boolean b){
        if (b){ //表示选中
            Toast.makeText(this,"选中了单选按钮",Toast.LENGTH_SHORT).show();
        }else{  //表示未选中
            Toast.makeText(this,"未选中单选按钮",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 设置Button的监听事件，方法名是我们自己定义的
     * @param view 这个参数是我们自己传入的，代表的是当前的Button
     */
    @OnClick(R.id.button)
    void setButton(View view){
        Toast.makeText(this,"点击了按钮",Toast.LENGTH_SHORT).show();
    }
}
