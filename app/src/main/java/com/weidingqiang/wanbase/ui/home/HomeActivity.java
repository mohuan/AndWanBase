package com.weidingqiang.wanbase.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

import com.weidingqiang.wanbase.R;
import com.weidingqiang.wanbase.base.RootFragmentActivity;
import com.weidingqiang.wanbase.ui.help.contract.HelpContract;
import com.weidingqiang.wanbase.ui.help.presenter.HelpPresenter;

/**
 * 0.删除多余信息
 * 1.导航
 * 2.列表
 * 3.视频
 * 4.微信登陆
 * 5.弹框
 */


public class HomeActivity extends RootFragmentActivity<HelpPresenter> implements HelpContract.View {

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void responeError(String errorMsg) {

    }

    @Override
    protected void initEventAndData() {
//        super.initEventAndData();
    }

    //连续俩下 退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static Intent newInstance(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }
}
