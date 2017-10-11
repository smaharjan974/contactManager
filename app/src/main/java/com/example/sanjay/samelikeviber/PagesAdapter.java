package com.example.sanjay.samelikeviber;

import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by SANJAY on 10/5/2017.
 */

public class PagesAdapter extends FragmentPagerAdapter {

    int nooffrags;

    public PagesAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.nooffrags=tabCount;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ContactFragment cf = new ContactFragment();
                return cf;
            case 1:
                return new AddContactFragment();
            case 2:
                return new MessageFragment();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {

        return nooffrags;
    }
}
