package com.weidingqiang.wanbase.di.component;

import android.app.Activity;

import com.weidingqiang.wanbase.di.module.FragmentModule;
import com.weidingqiang.wanbase.di.scope.FragmentScope;
import com.weidingqiang.wanbase.ui.help.fragment.HelpInfoFragment;
import com.weidingqiang.wanbase.ui.home.HomeFragment;
import com.weidingqiang.wanbase.ui.home.HomeFragment2;
import com.weidingqiang.wanbase.ui.home.HomeFragment3;
import com.weidingqiang.wanbase.ui.home.HomeFragment4;
import com.weidingqiang.wanbase.ui.main.fragment.DialogFragment;
import com.weidingqiang.wanbase.ui.main.fragment.DownUpFragment;
import com.weidingqiang.wanbase.ui.main.fragment.NewsFragment;
import com.weidingqiang.wanbase.ui.main.fragment.RoundImageFragment;

import dagger.Component;

/**
 * Created by weidingqiang on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(HelpInfoFragment helpInfoFragment);

    void inject(NewsFragment newsFragment);

    void inject(RoundImageFragment roundImageFragment);

    void inject(DialogFragment dialogFragment);

    void inject(DownUpFragment downUpFragment);

    void inject(HomeFragment homeFragment);

    void inject(HomeFragment2 homeFragment2);

    void inject(HomeFragment3 homeFragment3);

    void inject(HomeFragment4 homeFragment4);
}
