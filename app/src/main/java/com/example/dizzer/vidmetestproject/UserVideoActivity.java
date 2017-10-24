package com.example.dizzer.vidmetestproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.dizzer.vidmetestproject.fragment.AuthFragment;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.LogOut_button:
                SharedPreferences failPreferences = getSharedPreferences("Auth", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = failPreferences.edit();
                edit.putString(AuthFragment.LOGIN,null);
                edit.putString(AuthFragment.PASSWORD,null);
                edit.commit();
                Intent logout = new Intent(this,MainActivity.class);
                startActivity(logout);
                break;
        }
        return true;
    }
}
