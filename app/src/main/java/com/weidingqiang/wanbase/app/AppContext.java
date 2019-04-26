package com.weidingqiang.wanbase.app;

import android.app.ActivityManager;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.weidingqiang.rxqwelibrary.app.AppConfig;
import com.weidingqiang.rxqwelibrary.app.AppConstants;
import com.weidingqiang.rxqwelibrary.app.BaseApplication;
import com.weidingqiang.rxqwelibrary.app.CrashHandler;
import com.weidingqiang.rxqwelibrary.service.InitializeService;
import com.weidingqiang.wanbase.di.component.AppComponent;
import com.weidingqiang.wanbase.di.component.DaggerAppComponent;
import com.weidingqiang.wanbase.di.module.AppModule;
import com.weidingqiang.wanbase.di.module.HttpModule;

import java.util.Properties;


/**
 * 作者：weidingqiang on 2017/7/10 10:00
 * 邮箱：dqwei@iflytek.com
 */

public class AppContext extends BaseApplication {

    private static final String TAG = AppContext.class.getSimpleName();

    private static final String TOKEN = "user.token";

    private static AppContext instance;

    public static AppComponent appComponent;

    public String getToken() {
        return token;
    }

    private String token;

    private boolean login;

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

    public boolean initLogin() {

        if (AppConstants.DOWNLOAD_PATH.length() < 3) {
            return false;
        }

        if (getProperty(TOKEN)!= null) {
            //this.token = user.getToken();
            login = true;
            token = getProperty(TOKEN);
        } else {
            this.cleanLoginInfo();
        }
        return true;
    }

    /**
     * 保存登录信息
     *
     */
    @SuppressWarnings("serial")
    public void saveUserInfo(final String token) {
        this.login = true;
        this.token = token;
        setProperties(new Properties() {
            {
                setProperty(TOKEN, token);
            }
        });
    }

    /**
     * 清除登录信息
     */
    public void cleanLoginInfo() {
        //this.loginUid = 0;
        this.login = false;
        //removeProperty("user.name", "user.passwd", "user.token");
        removeProperty( TOKEN);
    }

    public void setProperties(Properties ps) {
        AppConfig.getAppConfig(this).set(ps);
    }

    public String getProperty(String key) {
        String res = AppConfig.getAppConfig(this).get(key);
        return res;
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(this).remove(key);
    }

    public boolean isLogin() {
        return login;
    }

    /**
     * 用户注销
     */
    public void Logout() {
        this.login = false;
        cleanLoginInfo();
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
