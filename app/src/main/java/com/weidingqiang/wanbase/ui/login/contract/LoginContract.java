package com.weidingqiang.wanbase.ui.login.contract;

import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;

/**
 * 作者：weidingqiang on 2017/9/7 15:36
 * 邮箱：dqwei@iflytek.com
 */

public interface LoginContract {

    interface View extends BaseView {
        //返回登陆结果
        void responeError(String errorMsg);
    }

    interface Presenter extends BasePresenter<View> {
    }
}
