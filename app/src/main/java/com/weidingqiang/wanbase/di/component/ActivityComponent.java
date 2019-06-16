package com.weidingqiang.wanbase.di.component;

import android.app.Activity;

import com.weidingqiang.wanbase.di.module.ActivityModule;
import com.weidingqiang.wanbase.di.scope.ActivityScope;
import com.weidingqiang.wanbase.ui.help.activity.HelpActivity;
import com.weidingqiang.wanbase.ui.home.HomeActivity;
import com.weidingqiang.wanbase.ui.home.VideoActivity;
import com.weidingqiang.wanbase.ui.login.activity.LoginActivity;
import com.weidingqiang.wanbase.ui.main.activity.MainActivity;
import com.weidingqiang.wanbase.ui.splash.activity.SplashActivity;

import dagger.Component;

/**
 * 作者：weidingqiang on 2017/7/10 16:04
 * 邮箱：dqwei@iflytek.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(LoginActivity loginActivity);

    void inject(HelpActivity helpActivity);

    void inject(SplashActivity splashActivity);

    void inject(HomeActivity homeActivity);

    void inject(VideoActivity videoActivity);
}
