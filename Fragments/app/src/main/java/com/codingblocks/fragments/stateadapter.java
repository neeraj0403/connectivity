package com.codingblocks.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class stateadapter extends FragmentStatePagerAdapter {
private List<Fragment> fragments=new ArrayList<>();
    private List<String> mfragments=new ArrayList<>();
    public stateadapter(FragmentManager fm) {
        super(fm);
    }
    public void addfragment(Fragment fragment,String title)
    {
        fragments.add(fragment);
        mfragments.add(title);

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
