package com.weidingqiang.wanbase.ui.login.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootActivity;
import com.weidingqiang.wanbase.ui.login.contract.LoginContract;
import com.weidingqiang.wanbase.ui.login.presenter.LoginPresenter;
import com.weidingqiang.wanbase.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

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
