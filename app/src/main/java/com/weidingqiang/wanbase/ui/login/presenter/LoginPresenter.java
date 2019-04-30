package com.weidingqiang.wanbase.ui.login.presenter;

import android.Manifest;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.weidingqiang.wanbase.app.AppContext;
import com.weidingqiang.wanbase.base.RxPresenter;
import com.weidingqiang.wanbase.model.DataManager;
import com.weidingqiang.wanbase.model.bean.UserVO;
import com.weidingqiang.wanbase.model.http.exception.ApiException;
import com.weidingqiang.wanbase.model.http.response.HttpResponse;
import com.weidingqiang.wanbase.ui.login.contract.LoginContract;
import com.weidingqiang.wanbase.utils.RxUtil;
import com.weidingqiang.wanbase.widget.CommonSubscriber;

import javax.inject.Inject;

/**
 * 作者：weidingqiang on 2017/9/7 15:39
 * 邮箱：dqwei@iflytek.com
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager mDataManager) {
        super(mDataManager);
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(LoginContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    private void registerEvent(){

    }

    @Override
    public void login(String loginName, String password) {
        addSubscribe(mDataManager.postLogin(loginName, password)
                .compose(RxUtil.<HttpResponse<UserVO>>rxSchedulerHelper())
                .compose(RxUtil.<UserVO>handleTestResult())
                .subscribeWith(
                        new CommonSubscriber<UserVO>(mView) {
                            @Override
                            public void onNext(UserVO userData) {

                                mDataManager.setLoginStatus(true);

                                mView.loginSuccess();
                            }


                            @Override
                            public void onError(Throwable e) {
                                //当数据返回为null时 做特殊处理
                                try {
                                    int code = ((ApiException) e).getCode();
                                    mView.responeError(e.getMessage());
                                    return;
                                } catch (Exception ex) {

                                }
                                mView.responeError("数据请求失败，请检查网络！");
                            }

                        }
                )
        );
    }

    @Override
    public void shareEventPermissionVerify(RxPermissions rxPermissions) {
        addSubscribe(rxPermissions
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        mView.shareEventSuccess();
                    } else {
                        mView.responeError("授权失败");
                    }
                }));
    }
}
