package com.example.dizzer.vidmetestproject.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dizzer.vidmetestproject.App;
import com.example.dizzer.vidmetestproject.MainActivity;
import com.example.dizzer.vidmetestproject.R;
import com.example.dizzer.vidmetestproject.adapter.RecyclerViewerAdapter;
import com.example.dizzer.vidmetestproject.model.Video;
import com.example.dizzer.vidmetestproject.model.Videos;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dizzer on 10/24/2017.
 */

public class FeedFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerViewerAdapter recyclerViewerAdapter;

    Unbinder unbinder;

    public List<Video> videos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.video_fragment_layout,container,false);
        unbinder = ButterKnife.bind(this,rootView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Auth", Context.MODE_PRIVATE);
        App.getApi().getFeedVideo(sharedPreferences.getString(AuthFragment.TOKEN,null)).enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                videos = response.body().getVideos();
                recyclerViewerAdapter = new RecyclerViewerAdapter(videos);
                recyclerView.setAdapter(recyclerViewerAdapter);
            }

            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                Toast.makeText(getActivity(),"Fail",Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
