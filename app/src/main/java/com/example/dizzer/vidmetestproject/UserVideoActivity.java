package com.example.dizzer.vidmetestproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dizzer.vidmetestproject.fragment.FeedFragment;

/**
 * Created by Dizzer on 10/24/2017.
 */

public class UserVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_video_activity);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        FeedFragment feedFragment = new FeedFragment();
        fragmentTransaction.add(R.id.userVideoActivity,feedFragment);
        fragmentTransaction.commit();
    }
}
