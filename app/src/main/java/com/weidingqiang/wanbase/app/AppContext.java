package com.weidingqiang.wanbase.app;

import android.app.ActivityManager;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.weidingqiang.rxqwelibrary.app.BaseApplication;
import com.weidingqiang.rxqwelibrary.app.CrashHandler;
import com.weidingqiang.rxqwelibrary.service.InitializeService;
import com.weidingqiang.wanbase.di.component.AppComponent;
import com.weidingqiang.wanbase.di.component.DaggerAppComponent;
import com.weidingqiang.wanbase.di.module.AppModule;
import com.weidingqiang.wanbase.di.module.HttpModule;


/**
 * 作者：weidingqiang on 2017/7/10 10:00
 * 邮箱：dqwei@iflytek.com
 */

public class AppContext extends BaseApplication {

    private static final String TAG = AppContext.class.getSimpleName();

    private static AppContext instance;

    public static AppComponent appComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        //在子线程中完成其他初始化
        InitializeService.start(this);

        //初始化崩溃信息
//        initCrash();

    }

    private void initCrash() {
        // 获取异常信息捕获类实例
        //        开发期间不要监听 稍后放开
        CrashHandler crashHandler = CrashHandler.getInstance(getApplicationContext());

        crashHandler.setICrashHandlerListener(this);
        // 初始化
        crashHandler.init(getApplicationContext());
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    /**
     * 获得当前app运行的AppContext
     */
    public static AppContext getInstance() {
        return instance;
    }

    private String getProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
