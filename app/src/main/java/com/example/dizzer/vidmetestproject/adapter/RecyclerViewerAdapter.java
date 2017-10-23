package com.example.dizzer.vidmetestproject.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.dizzer.vidmetestproject.R;
import com.example.dizzer.vidmetestproject.model.Video;
import com.example.dizzer.vidmetestproject.util.VideoWebViewClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dizzer on 10/23/2017.
 */

public class RecyclerViewerAdapter extends RecyclerView.Adapter<RecyclerViewerAdapter.ViewHolder> {

    private List<Video> videos;

    public RecyclerViewerAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(videos.get(position).getTitle());
        holder.likes.setText("Likes: " + videos.get(position).getScore());
        holder.videoView.getSettings().setJavaScriptEnabled(true);
        holder.videoView.getSettings().setPluginState(WebSettings.PluginState.ON);
        holder.videoView.setWebViewClient(new VideoWebViewClient());
        holder.videoView.loadUrl(videos.get(position).getEmbedUrl()+"?autoplay=1");
    }

    @Override
    public int getItemCount() {
        if (videos == null){
            return 0;
        }
        return videos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.videoTitle)
        TextView title;
        @BindView(R.id.likeCount)
        TextView likes;
        @BindView(R.id.videoView)
        WebView videoView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
