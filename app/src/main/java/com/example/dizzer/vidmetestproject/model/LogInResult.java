package com.example.dizzer.vidmetestproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dizzer on 10/24/2017.
 */

public class LogInResult {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("auth")
    private Auth auth;

    public Boolean getStatus() {
        return status;
    }

    public Auth getAuth() {
        return auth;
    }

    public static class Auth {

        @SerializedName("token")
        private String token;
        @SerializedName("expires")
        private String expires;
        @SerializedName("user_id")
        private String userId;

        public String getToken() {
            return token;
        }

    }
}
