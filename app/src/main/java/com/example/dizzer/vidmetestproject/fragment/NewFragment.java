package com.example.dizzer.vidmetestproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dizzer.vidmetestproject.App;
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

public class NewFragment extends Fragment {
    @BindView(R.id.refresher)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerViewerAdapter recyclerViewerAdapter;

    private Unbinder unbinder;

    public List<Video> videos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.video_fragment_layout,container,false);
        unbinder = ButterKnife.bind(this,rootView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getVideos();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getVideos();
                recyclerViewerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return rootView;
    }

    public void getVideos(){
        App.getApi().getNewVideo().enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                videos = response.body().getVideos();
                recyclerViewerAdapter = new RecyclerViewerAdapter(videos);
                recyclerView.setAdapter(recyclerViewerAdapter);
            }

            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                Toast.makeText(getActivity(),"An error occurred during networking",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
