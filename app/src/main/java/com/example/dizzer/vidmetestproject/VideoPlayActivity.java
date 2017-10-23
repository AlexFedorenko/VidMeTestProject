package com.example.dizzer.vidmetestproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dizzer on 10/23/2017.
 */

public class VideoPlayActivity extends AppCompatActivity{

    @BindView(R.id.videoPlayer)
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play_layout);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }
        super.onBackPressed();
    }
}
