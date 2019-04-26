package com.weidingqiang.wanbase.di.module;

import com.weidingqiang.wanbase.app.AppContext;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.model.http.HttpHelper;
import com.weidingqiang.wanbase.model.http.RetrofitHelper;
import com.weidingqiang.wanbase.model.prefs.ImplPreferencesHelper;
import com.weidingqiang.wanbase.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：weidingqiang on 2017/7/10 14:43
 * 邮箱：dqwei@iflytek.com
 */
@Module
public class AppModule {

    private final AppContext application;

    public AppModule(AppContext application) {
        this.application = application;
    }

    @Provides
    @Singleton
    AppContext provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper,preferencesHelper);
    }
}
