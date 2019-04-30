package com.weidingqiang.wanbase.di.component;

import android.app.Activity;

import com.weidingqiang.wanbase.di.module.FragmentModule;
import com.weidingqiang.wanbase.di.scope.FragmentScope;
import com.weidingqiang.wanbase.ui.help.fragment.HelpInfoFragment;
import com.weidingqiang.wanbase.ui.main.fragment.NewsFragment;

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

}
