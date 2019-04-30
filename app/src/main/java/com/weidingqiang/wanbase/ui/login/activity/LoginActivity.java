package com.weidingqiang.wanbase.ui.login.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.ui.login.contract.LoginContract;
import com.weidingqiang.wanbase.ui.login.presenter.LoginPresenter;
import com.weidingqiang.wanbase.ui.main.MainActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * name: qwe112211
 * pass: 112233
 */

public class LoginActivity extends RootActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.username_edit)
    EditText username_edit;

    @BindView(R.id.password_edit)
    EditText password_edit;

    @BindView(R.id.login_button)
    Button login_button;

    @BindView(R.id.permiss_button)
    Button permiss_button;


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

        mPresenter.addRxBindingSubscribe(RxView.clicks(permiss_button)
                .throttleFirst(2, TimeUnit.MILLISECONDS)
                .filter(o -> mPresenter != null)
                .subscribe(o ->
                        mPresenter.shareEventPermissionVerify(new RxPermissions(this))
                ));
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @OnClick(R.id.login_button)
    void onLoginButton(){
        login_button.setEnabled(false);

        //用户登陆
        String username = username_edit.getText().toString();
        String userpassword = password_edit.getText().toString();

        //1.判断账号不能为空
        if (StringUtils.isSpace(username) || StringUtils.isSpace(userpassword)) {
            ToastUtils.showShort("用户名或者密码不能为空");
            login_button.setEnabled(true);
        } else {
//            mPresenter.login("zhangsan","123456");
            mPresenter.login(username, userpassword);
        }

    }

    @Override
    public void shareEventSuccess() {

    }

    @Override
    public void loginSuccess() {
        login_button.setEnabled(true);

        startActivity(MainActivity.newInstance(getApplicationContext()));
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
