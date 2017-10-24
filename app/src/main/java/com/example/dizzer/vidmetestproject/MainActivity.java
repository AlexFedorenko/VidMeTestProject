package com.example.dizzer.vidmetestproject;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dizzer.vidmetestproject.adapter.PageAdapter;
import com.example.dizzer.vidmetestproject.adapter.RecyclerViewerAdapter;
import com.example.dizzer.vidmetestproject.model.Video;
import com.example.dizzer.vidmetestproject.model.Videos;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.recyclerView)
//    RecyclerView recyclerView;
    @BindView(R.id.pageContainer)
    ViewPager viewPager;

    RecyclerViewerAdapter recyclerViewerAdapter;
    public List<Video> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));

       /* recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        App.getApi().getFeaturedVideo(2).enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                videos = response.body().getVideos();
                recyclerViewerAdapter = new RecyclerViewerAdapter(videos);
                recyclerView.setAdapter(recyclerViewerAdapter);
            }

            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Feil",Toast.LENGTH_LONG).show();
            }
        });*/
    }
}
