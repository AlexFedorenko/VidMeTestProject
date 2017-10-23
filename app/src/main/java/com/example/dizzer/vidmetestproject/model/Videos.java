package com.example.dizzer.vidmetestproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dizzer on 10/23/2017.
 */

public class Videos {
    @SerializedName("videos")
    @Expose
    List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
