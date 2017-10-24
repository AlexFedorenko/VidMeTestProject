package com.example.dizzer.vidmetestproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dizzer.vidmetestproject.fragment.AuthFragment;
import com.example.dizzer.vidmetestproject.fragment.FeaturedFragment;
import com.example.dizzer.vidmetestproject.fragment.NewFragment;

/**
 * Created by Dizzer on 10/24/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new FeaturedFragment();
            case 1:
                return new NewFragment();
            case 2:
                return new AuthFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Featured";
            case 1 : return "New";
            case 2 : return "Feed";
        }

        return null;
    }
}
