package com.zyf.myapplication.butterknife;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.zyf.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by 11213 on 2017/1/9.
 */

public class HolderActivity extends AppCompatActivity {

    private List<String> list1 = new ArrayList<>();

    @BindView(R.id.list)
    ListView list;

    //ButterKnife绑定资源
    @BindDrawable(R.mipmap.head) Drawable head;
    @BindColor(R.color.colorAccent) int colorAccent;
    @BindString(R.string.app_name) String app_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        ButterKnife.bind(this);

        setI();
        list.setAdapter(new HodlerAdapter(this,list1));

    }

    @OnItemClick(R.id.list)
    void setList(int i, View v){
        Toast.makeText(this,"点击了第"+i+"个子条目",Toast.LENGTH_SHORT).show();
        ImageView im = (ImageView) v.findViewById(R.id.head);
        Drawable d = im.getBackground();
        Log.e("main",d.toString());
    }

    private void setI(){
        for (int i = 0; i < 100; i++) {
            list1.add("测试"+i);
        }
    }
}
