package com.weidingqiang.wanbase.di.component;

import android.app.Activity;

import com.weidingqiang.wanbase.di.module.ActivityModule;
import com.weidingqiang.wanbase.di.scope.ActivityScope;

import dagger.Component;

/**
 * 作者：weidingqiang on 2017/7/10 16:04
 * 邮箱：dqwei@iflytek.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();

//    void inject(MainActivity mainActivity);


}
