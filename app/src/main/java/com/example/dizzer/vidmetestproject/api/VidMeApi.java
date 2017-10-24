package com.example.dizzer.vidmetestproject.api;

import com.example.dizzer.vidmetestproject.model.LogInResult;
import com.example.dizzer.vidmetestproject.model.Videos;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dizzer on 10/23/2017.
 */

public interface VidMeApi {

    @GET("/videos/featured")
    Call<Videos> getFeaturedVideo();

    @GET("/videos/new")
    Call<Videos> getNewVideo();

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("/auth/create")
    Call<LogInResult>insertUser(@Field("username") String username,
                                @Field("password") String password
    );
}
