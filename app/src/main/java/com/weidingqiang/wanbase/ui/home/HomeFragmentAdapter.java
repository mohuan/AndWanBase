package com.weidingqiang.wanbase.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * 作者：weidingqiang on 2019-06-15 14:20
 * 邮箱：weidingqiang@163.com
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {

    String[] mTitles;

    public HomeFragmentAdapter(FragmentManager fm, String... titles) {
        super(fm);
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
//            return  HomeFragment2.newInstance();
//            return HomeFragment3.newInstance();
            return HomeFragment4.newInstance();
//            return HomeFragment.newInstance();
        } else if (position == 1) {
            return HomeFragment2.newInstance();
        } else if(position ==3){
            return HomeFragment3.newInstance();
        }else {
            return HomeFragment4.newInstance();
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
