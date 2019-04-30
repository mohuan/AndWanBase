package com.weidingqiang.wanbase.ui.main.contract;

import com.weidingqiang.rxqwelibrary.base.BasePresenter;
import com.weidingqiang.rxqwelibrary.base.BaseView;

/**
 * Created by Lionel2Messi
 */
public interface DownUpContract {

    interface View extends BaseView {
        //返回登陆结果
        void responeError(String errorMsg);
    }

    interface Presenter extends BasePresenter<View> {
    }
}