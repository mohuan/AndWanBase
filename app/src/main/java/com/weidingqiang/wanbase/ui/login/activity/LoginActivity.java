package com.weidingqiang.wanbase.ui.login.activity;

import android.content.Context;
import android.content.Intent;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.ui.login.contract.LoginContract;
import com.weidingqiang.wanbase.ui.login.presenter.LoginPresenter;

public class LoginActivity extends RootActivity<LoginPresenter> implements LoginContract.View {

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void responeError(String errorMsg) {

    }

    /**
     * 打开新Activity
     *
     * @param context
     * @return
     */
    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
}
