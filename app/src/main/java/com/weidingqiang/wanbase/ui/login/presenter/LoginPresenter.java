package com.weidingqiang.wanbase.ui.login.presenter;

import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.ui.login.contract.LoginContract;

import javax.inject.Inject;

/**
 * 作者：weidingqiang on 2017/9/7 15:39
 * 邮箱：dqwei@iflytek.com
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(LoginContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent(){

    }

}
