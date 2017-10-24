package com.example.dizzer.vidmetestproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dizzer.vidmetestproject.fragment.FeaturedFragment;

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
                return new FeaturedFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 : return "Featured";
            case 1 : return "New";
        }

        return null;
    }
}
