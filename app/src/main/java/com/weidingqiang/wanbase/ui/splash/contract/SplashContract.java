package com.weidingqiang.wanbase.ui.splash.contract;

import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;

/**
 * Created by weidingqiang
 */
public interface SplashContract {

    interface View extends BaseView {
        //返回登陆结果
        void responeError(String errorMsg);
    }

    interface Presenter extends BasePresenter<View> {
        boolean isLogin();
    }
}