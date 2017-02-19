package com.zyf.myapplication.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 */

public class BufferKnifeFragment extends Fragment {

    @BindView(R.id.tv_butterknife)
    TextView tvButterknife;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.button)
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_butter_knife, container, false);
        //初始化Butterknife，和Activity有一定的区别
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvButterknife.setText("这是Fragment中使用ButterKnife");
    }

    @OnClick(R.id.button)
    void setButton(){
        Toast.makeText(getActivity(),"点击了按钮",Toast.LENGTH_SHORT).show();
    }

    @OnCheckedChanged(R.id.checkbox)
    void setCheckbox(boolean b){
        if (b){
            Toast.makeText(getActivity(),"选中了",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(),"没选中",Toast.LENGTH_SHORT).show();
        }
    }
}
