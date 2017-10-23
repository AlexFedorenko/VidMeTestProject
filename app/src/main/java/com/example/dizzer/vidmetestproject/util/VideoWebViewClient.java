package com.example.dizzer.vidmetestproject.util;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Dizzer on 10/23/2017.
 */

public class VideoWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
