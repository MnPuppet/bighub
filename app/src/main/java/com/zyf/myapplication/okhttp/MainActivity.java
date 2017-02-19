package com.zyf.myapplication.okhttp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zyf.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        imageView = ((ImageView) findViewById(R.id.image));
        textView = ((TextView) findViewById(R.id.tv));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                downLoadImage();
                break;
            default:
                break;
        }
    }

    /**
     * 提交表单
     * @param s  请求的Url
     */
    private void formPost(String s){
        //获取手机SDK中的文件（手机内存我们可操作的分为三部分，“系统文件盘”，“内置SD卡”，“外置SD卡”）
        //在我们写程序时说的SD卡，指的是内置SD卡
        File file = new File(Environment.getExternalStorageDirectory(),"1.png");
        if (!file.exists()){  //如果没有文件则直接结束
            Toast.makeText(this,"文件不存在",Toast.LENGTH_SHORT).show();
            return;
        }

        //创建OKHttp的请求客户端
        OkHttpClient okHttpClient = new OkHttpClient();

        //创建请求体，这个地方用的是MuLtipartBody这个类
        RequestBody body = new MultipartBody.Builder()
                //当我们要提交表单的时候必须要加上这句代码
                .setType(MultipartBody.FORM)
                //这是普通的添加表单信息
                .addFormDataPart("username","admin")
                .addFormDataPart("password","admin")
                //这是添加一个流文件的方式
                .addFormDataPart("mufile","1.png",RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();

        UpLoadBody upLoadBody = new UpLoadBody(body, new UpLoadBody.UpLoadListener() {
            @Override
            public void onRequestProgress(long byteWritted, long contentLength) {
                //byteWritted:加载的进度  contentLength:总进度
                Log.e("main","进度："+byteWritted+"/"+contentLength);
            }
        });

        //创建请求体
        Request request = new Request.Builder()
                .url(s)
                .post(upLoadBody)
                .build();

        //请求回掉
        Call call = okHttpClient.newCall(request);

        //获取请求结果
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("main", response.body().string());
            }
        });
    }

    /**
     * 从网络上加载图片
     */
    private void downLoadImage(){
        //创建请求客户端
        OkHttpClient client = new OkHttpClient();
        //配置请求信息
        Request reqiest = new Request.Builder()
                .url("http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg")
                .get()
                .build();
        //创建请求
        Call call = client.newCall(reqiest);
        //请求结果回掉
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("main","faile");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //通过这种方式拿到流
                InputStream is = response.body().byteStream();
                //拿到文件的总大小
                final long total = response.body().contentLength();
                //进行文件读取
                int length = 0;
                //记录一共下载多少
                long sum = 0L;
                File file = new File(Environment.getExternalStorageDirectory(),"i.jpg");
                Log.e("main",Environment.getExternalStorageState());
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buf = new byte[128];
                while((length = is.read(buf)) != -1){
                    fos.write(buf,0,length);
                    sum += length;
                    final long finalsum = sum;
                    Log.d("pyh1", "onResponse: " + finalsum + "/" + total);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //将进度设置到TextView中,这里也可以是一个进度对话框
                            textView.setText(finalsum + "/" + total);
                        }
                    });

                }

                fos.flush();
                fos.close();
                is.close();
            }

        });
    }

    /**
     * 把文件下载到本地，就是文件的读写
     * @param is
     * @throws IOException
     */
    private void write(InputStream is) throws IOException {
        int length = 0;
        File file = new File(Environment.getExternalStorageDirectory(),"baidu.jpg");
        Log.e("main",Environment.getExternalStorageState());
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buf = new byte[128];
        while((length = is.read(buf)) != -1){
            fos.write(buf,0,length);
        }

        fos.flush();
        fos.close();
        is.close();
    }




}
