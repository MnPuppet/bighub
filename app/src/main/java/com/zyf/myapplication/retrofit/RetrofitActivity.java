package com.zyf.myapplication.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zyf.myapplication.R;
import com.zyf.myapplication.retrofit.converter.StringConverterFactory;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 11213 on 2017/1/9.
 */

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button mButton1;
    @BindView(R.id.button2)
    Button mButton2;
    @BindView(R.id.button3)
    Button mButton3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                loadPost();
                break;
            case R.id.button2:
                loadGet();
                break;
            case R.id.button3:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        loadAsyGet();
                    }
                }).start();
                break;
        }
    }

    /**
     * 异步请求Post
     */
    private void loadPost() {

        Retrofit retrofit = new Retrofit.Builder()
                //设置一个OkHttpClient,如果不设置会提供一个默认的
                .client(new OkHttpClient())
                //设置baseUrl
                .baseUrl("https://tcc.taobao.com/")
                //添加一个Json转换器
                .addConverterFactory(StringConverterFactory.create())
                .build();

        //创建请求的类
        RequestApiService service = retrofit.create(RequestApiService.class);

        Call<String> call = service.getMobile("18532455387");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String String = response.body();
               Log.e("--main--",String);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                if (t instanceof Exception) {
                    ((Exception) t).printStackTrace();
                }else{
                    Log.e("--main--","出错啦");
                }
            }
        });
    }

    /**
     * 异步Get请求
     */
    private void loadGet(){

        Retrofit retrofit = new Retrofit.Builder()
                //设置一个OkHttpClient,如果不设置会提供一个默认的
                .client(new OkHttpClient())
                //设置baseUrl
                .baseUrl("http://git.oschina.net/api/v3/")
                //添加一个Json转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestApiService service = retrofit.create(RequestApiService.class);

        Call<List<Project>> call = service.getP();

        call.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                List<Project> list =  response.body();
                for (Project project : list) {
                    Log.e("--main--",project.getId());

                }

            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Log.e("--main--","出错啦");
            }
        });
    }

    private void loadAsyGet(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://git.oschina.net/api/")
                .addConverterFactory(StringConverterFactory.create())
                .build();
        RequestApiService service = retrofit.create(RequestApiService.class);

        Call<String> call = service.getPr();
        try {
            Response<String> response = call.execute();
            String s = response.body();
            Log.e("--main--",s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}