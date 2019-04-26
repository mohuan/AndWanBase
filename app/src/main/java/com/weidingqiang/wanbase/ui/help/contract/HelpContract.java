package com.weidingqiang.wanbase.ui.help.contract;

import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;

/**
 * Created by skyworth
 */
public interface HelpContract {

    interface View extends BaseView {
        //返回登陆结果
        void responeError(String errorMsg);
    }

    interface Presenter extends BasePresenter<View> {
    }
}