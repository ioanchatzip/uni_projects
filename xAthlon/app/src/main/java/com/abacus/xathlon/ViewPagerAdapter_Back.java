package com.abacus.xathlon;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter_Back extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList_Back = new ArrayList<>();
    private final List<String> FragmentListTitles = new ArrayList<>();

    public ViewPagerAdapter_Back(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList_Back.get(position);
    }


    @Override
    public int getCount() {return FragmentListTitles.size();}

    @Nullable
    @Override
    public  CharSequence getPageTitle(int position){
        return FragmentListTitles.get(position);
    }

    public void  AddFragment(Fragment fragment,String Title){
        fragmentList_Back.add(fragment);
        FragmentListTitles.add(Title);
    }
}