package com.zyf.myapplication.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.zyf.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 11213 on 2017/1/6.
 */

public class FragmentActivity extends AppCompatActivity {

    @BindView(R.id.viewGroup)
    LinearLayout viewGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);

        addFragment();
    }

    //添加Fragment到Activity中
    private void addFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.viewGroup,new BufferKnifeFragment());
        transaction.commit();
    }
}
