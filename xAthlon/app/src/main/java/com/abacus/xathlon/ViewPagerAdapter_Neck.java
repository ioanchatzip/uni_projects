package com.abacus.xathlon;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter_Neck extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList_Neck = new ArrayList<>();
    private final List<String> FragmentListTitles = new ArrayList<>();

    public ViewPagerAdapter_Neck(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList_Neck.get(position);
    }


    @Override
    public int getCount() {return FragmentListTitles.size();}

    @Nullable
    @Override
    public  CharSequence getPageTitle(int position){
        return FragmentListTitles.get(position);
    }

    public void  AddFragment(Fragment fragment,String Title){
        fragmentList_Neck.add(fragment);
        FragmentListTitles.add(Title);
    }
}