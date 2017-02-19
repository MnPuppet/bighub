package com.zyf.myapplication.okhttp;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * Created by 11213 on 2017/1/4.
 * 自定义请求体，继承RequestBody
 */

public class UpLoadBody extends RequestBody {
    //请求体，具体是有这个上传参数
    private RequestBody requestBody;
    //回调上传进度的接口
    private UpLoadListener listener;

    private CountingSink countingSink;

    /**
     * 构造函数
     * @param requestBody  给真正的请求体赋值
     * @param listener   接口
     */
    public UpLoadBody(RequestBody requestBody,UpLoadListener listener){
        this.requestBody = requestBody;
        this.listener = listener;
    }

    //上传内容类型，调用真实上传体的类容类型
    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        countingSink = new CountingSink(sink);
        //将CountingSink转化为BufferedSink供writeTo()使用
        BufferedSink bufferedSink = Okio.buffer(countingSink);
        requestBody.writeTo(bufferedSink);
        bufferedSink.flush();
    }

    protected final class CountingSink extends ForwardingSink {
        //上传中的进度
        private long byteWritten;
        public CountingSink(Sink delegate) {
            super(delegate);
        }

        /**
         * 上传时调用该方法,在其中调用回调函数将上传进度暴露出去,该方法提供了缓冲区的自己大小
         * @param source
         * @param byteCount
         * @throws IOException
         */
        @Override
        public void write(Buffer source, long byteCount) throws IOException {
            super.write(source, byteCount);
            byteWritten += byteCount;
            listener.onRequestProgress(byteWritten, contentLength());
        }
    }

    /**
     * 返回文件总的字节大小
     * 如果文件大小获取失败则返回-1
     * @return
     */
    @Override
    public long contentLength(){
        try {
            return requestBody.contentLength();
        } catch (IOException e) {
            return -1;
        }
    }

    public interface UpLoadListener{

        /**
         * 暴露出上传进度的接口
         * @param byteWritted    上传进度
         * @param contentLength  总长度
         */
        void onRequestProgress(long byteWritted, long contentLength);
    }

}
