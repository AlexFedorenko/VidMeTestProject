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
    @SerializedName("complete")
    @Expose
    private String complete;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("full_url")
    @Expose
    private String fullUrl;
    @SerializedName("embed_url")
    @Expose
    private String embedUrl;


    public String getUrl() {
        return url;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public String getComplete(){
        return complete;
    }

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

