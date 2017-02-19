package com.zyf.myapplication.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Kelvin
 * @time 2017/1/18 11:47
 * @des ${TODO}
 */

public interface RequestApiService {

    @POST("cc/json/mobile_tel_segment.htm")
    Call<String> getMobile(@Query("tel") String tel);

    @GET("projects/featured")
    Call<List<Project>> getProject(@Query("page") int i);

    @GET("projects/featured")
    Call<List<Project>> getP();

    @GET("projects/featured")
    Call<String> getPr();


}
