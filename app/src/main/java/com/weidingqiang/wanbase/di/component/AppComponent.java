package com.weidingqiang.wanbase.di.component;

import com.weidingqiang.wanbase.app.AppContext;
import com.weidingqiang.wanbase.di.module.AppModule;
import com.weidingqiang.wanbase.di.module.HttpModule;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：weidingqiang on 2017/7/10 14:40
 * 邮箱：dqwei@iflytek.com
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    AppContext getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类
}
