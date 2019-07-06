package com.weidingqiang.wanbase.di.component;

import android.app.Activity;

import com.weidingqiang.wanbase.di.module.FragmentModule;
import com.weidingqiang.wanbase.di.scope.FragmentScope;
import com.weidingqiang.wanbase.ui.down.fragment.DownedFragment;
import com.weidingqiang.wanbase.ui.down.fragment.DowningFragment;
import com.weidingqiang.wanbase.ui.help.fragment.HelpInfoFragment;
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

    void inject(DownedFragment downedFragment);

    void inject(DowningFragment downingFragment);

}
