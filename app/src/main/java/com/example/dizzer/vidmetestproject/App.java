package com.example.dizzer.vidmetestproject;

import android.app.Application;

import com.example.dizzer.vidmetestproject.api.VidMeApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dizzer on 10/23/2017.
 */

public class App extends Application {

    public static final String BASE_URL = "https://api.vid.me/";
    public static VidMeApi vidMeApi;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vidMeApi = retrofit.create(VidMeApi.class);
    }

    public static VidMeApi getApi(){
        return vidMeApi;
    }


}
