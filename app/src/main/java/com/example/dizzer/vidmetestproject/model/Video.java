package com.example.dizzer.vidmetestproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dizzer on 10/23/2017.
 */

public class Video {
    @SerializedName("complete_url")
    @Expose
    private String complete_url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnail_url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("likes_count")
    @Expose
    private Integer likes_count;

    public String getComplete_url() {
        return complete_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getTitle() {
        return title;
    }

    public Integer getScore() {
        return likes_count;
    }
}

