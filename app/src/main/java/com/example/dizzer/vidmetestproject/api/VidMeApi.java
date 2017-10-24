package com.example.dizzer.vidmetestproject.api;

import com.example.dizzer.vidmetestproject.model.Videos;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dizzer on 10/23/2017.
 */

public interface VidMeApi {

    @GET("/videos/featured")
    Call<Videos> getFeaturedVideo();

    @GET("/videos/new")
    Call<Videos> getNewVideo();
}
